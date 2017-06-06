package com.cws.alarm.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Generated by JFinal, do not modify this file.
 * <pre>
 * Example:
 * public void configPlugin(Plugins me) {
 *     ActiveRecordPlugin arp = new ActiveRecordPlugin(...);
 *     _MappingKit.mapping(arp);
 *     me.add(arp);
 * }
 * </pre>
 */
public class _MappingKit {

	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("adas_collide", "id", AdasCollide.class);
		arp.addMapping("adas_collide_gps", "id", AdasCollideGps.class);
		arp.addMapping("adas_collide_senser", "id", AdasCollideSenser.class);
		arp.addMapping("adas_cycledata", "id", AdasCycledata.class);
		arp.addMapping("adas_emergency", "id", AdasEmergency.class);
		arp.addMapping("adas_emergency_gps", "id", AdasEmergencyGps.class);
		arp.addMapping("adas_emergency_senser", "id", AdasEmergencySenser.class);
		arp.addMapping("adas_gpsdata", "id", AdasGpsdata.class);
		arp.addMapping("adas_senserdata", "id", AdasSenserdata.class);
		arp.addMapping("adas_trips", "id", AdasTrips.class);
		arp.addMapping("adas_warning", "id", AdasWarning.class);
		arp.addMapping("hdx_trips_task", "id", HdxTripsTask.class);
		arp.addMapping("hdx_vehicles_trips", "id", HdxVehiclesTrips.class);
	}
}
