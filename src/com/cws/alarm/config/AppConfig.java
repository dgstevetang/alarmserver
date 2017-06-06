package com.cws.alarm.config;

import com.alibaba.druid.filter.config.ConfigFilter;
import com.alibaba.druid.filter.logging.Log4jFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.cws.alarm.model._MappingKit;
import com.cws.alarm.module.www.controller.IndexController;
import com.cws.alarm.server.DmsServerStarter;
import com.easyj.core.config.BaseConfig;
import com.easyj.core.plugin.Cron4jPlugin;
import com.easyj.core.plugin.sqlinxml.SqlInXmlPlugin;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

/**
 * **************************************************************************
 *
 * @说明:
 * @项目名称:
 * @author: tangweibin
 * @创建时间: 2017/5/25.
 * <p>
 * **************************************************************************
 */
public class AppConfig extends BaseConfig {
    private final static Log log = Log.getLog(AppConfig.class);
    public AppConfig(){
        loadProp("sys.properties", "dev.properties");
    }
    @Override
    public void configConstant(Constants me) {
        me.setBaseUploadPath(PathKit.getWebRootPath().concat("/upload_cache"));
        me.setDevMode(PropKit.getBoolean("devMode", false));
        me.setViewType(ViewType.JFINAL_TEMPLATE);
        me.setMaxPostSize(1024 * 1024 * 20);

        //ApiConfigKit 设为开发模式可以在开发阶段输出请求交互的 xml 与 json 数据
        //ApiConfigKit.setDevMode(isDebugCodeModel());

        //SysConfigBean configBean = getConfigBean();
    }

    @Override
    public void configRoute(Routes routes) {
        routes.setBaseViewPath("/view");
        routes.add("/",IndexController.class);
     }

    @Override
    public void configEngine(Engine me) {

    }
    public static DruidPlugin createDruidPlugin() {
        DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
        return  druidPlugin;
    }
    public static DruidPlugin createCrmPlugin() {
        DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("crmJdbcUrl"), PropKit.get("crmUser"), PropKit.get("crmPassword").trim());
        return  druidPlugin;
    }

    @Override
    public void configPlugin(Plugins plugins) {
        //EHCache缓存
        plugins.add(new EhCachePlugin(PathKit.getRootClassPath().concat("/ehcache.xml")));

        // 配置ActiveRecord插件
        DruidPlugin druidPlugin = createDruidPlugin();
        String connectionProperties = "config.decrypt=true;config.decrypt.key=" + PropKit.get("config.decrypt.key");
        druidPlugin.setConnectionProperties(connectionProperties);
        ConfigFilter configFilter = new ConfigFilter();
        druidPlugin.addFilter(configFilter);
        druidPlugin.setTestOnBorrow(false);
        druidPlugin.setTestOnReturn(false);
        druidPlugin.setValidationQuery("select 1");
        druidPlugin.setTestWhileIdle(true);
        druidPlugin.setMaxPoolPreparedStatementPerConnectionSize(20);
        druidPlugin.setRemoveAbandoned(true);
        druidPlugin.setRemoveAbandonedTimeoutMillis(1800 * 1000);   //毫秒(30分钟)
        druidPlugin.setLogAbandoned(true);
        StatFilter statFilter = new StatFilter();
        statFilter.setMergeSql(true);
        statFilter.setLogSlowSql(true);
        statFilter.setSlowSqlMillis(5000);
        druidPlugin.addFilter(statFilter);

        Log4jFilter log4jFilter = new Log4jFilter();
        druidPlugin.addFilter(log4jFilter);

        WallFilter wall = new WallFilter();
        wall.setDbType("mysql");
        druidPlugin.addFilter(wall);
        plugins.add(druidPlugin);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        arp.setContainerFactory(new CaseInsensitiveContainerFactory(true));
        arp.setShowSql(PropKit.getBoolean("showSql", true));
        plugins.add(arp);

        _MappingKit.mapping(arp);
        //添加crm数据连接
        DruidPlugin crmDruidPlugin = createCrmPlugin();
        String crmConnectionProperties = "config.decrypt=true;config.decrypt.key=" + PropKit.get("crm.decrypt.key");
        crmDruidPlugin.setConnectionProperties(crmConnectionProperties);
        ConfigFilter crmConfigFilter = new ConfigFilter();
        crmDruidPlugin.addFilter(crmConfigFilter);
        plugins.add(crmDruidPlugin);
        ActiveRecordPlugin arpCrm = new ActiveRecordPlugin("crm",crmDruidPlugin);
        plugins.add(arpCrm);

        //开发时使用，生产环境不需要
        if(JFinal.me().getConstants().getDevMode()) {
            //配置SQLINXML插件
            SqlInXmlPlugin sqlInXmlPlugin = new SqlInXmlPlugin();
            plugins.add(sqlInXmlPlugin);
        }


        //配置Cron4j插件
        if(isDebugCodeModel()){
            plugins.add(new Cron4jPlugin(PathKit.getRootClassPath().concat("/job.dev.properties")));
        }else{
            plugins.add(new Cron4jPlugin(PathKit.getRootClassPath().concat("/job.properties")));
        }
        //nettyserver
        DmsServerStarter dmsServerStarter = new DmsServerStarter();
        plugins.add(dmsServerStarter);

    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }
}
