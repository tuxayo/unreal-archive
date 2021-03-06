package net.shrimpworks.unreal.archive.content.maps;

public class Themes {

	public static final int MAX_THEMES = 5;
	public static final double MIN_THRESHOLD = 0.05d; // only include something as a theme if it contributes more than 5%

	public static final java.util.Map<String, String> THEMES;

	static final String TH_ANCIENT = "Ancient";
	static final String TH_NALI_TEMPLE = "Nali Temple";
	static final String TH_NALI_CASTLE = "Nali Castle";
	static final String TH_TECH = "Tech";
	static final String TH_INDUSTRIAL = "Industrial";
	static final String TH_CITY = "City";
	static final String TH_EGYPTIAN = "Egyptian";
	static final String TH_NATURAL = "Natural";
	static final String TH_SKAARJ_TECH = "Skaarj Tech";
	static final String TH_SKAARJ_CRYPT = "Skaarj Crypt";

	static {
		THEMES = java.util.Map.<String, String>ofEntries(
				/*
				  Unreal Tournament
				*/
				java.util.Map.entry("ancient", TH_NALI_TEMPLE),
				java.util.Map.entry("arenatex", TH_TECH),
				java.util.Map.entry("coret_fx", TH_TECH),
				java.util.Map.entry("city", TH_CITY),
				java.util.Map.entry("crypt_fx", TH_SKAARJ_CRYPT),
				java.util.Map.entry("crypt2", TH_SKAARJ_CRYPT),
				java.util.Map.entry("decayeds", TH_SKAARJ_TECH),
				java.util.Map.entry("egypt", TH_EGYPTIAN),
				java.util.Map.entry("egyptpan", TH_EGYPTIAN),
				java.util.Map.entry("eol", TH_ANCIENT),
				java.util.Map.entry("fractalfx", TH_TECH),
				java.util.Map.entry("genearth", TH_NATURAL),
				java.util.Map.entry("genfluid", TH_NATURAL),
				java.util.Map.entry("genin", TH_ANCIENT),
				java.util.Map.entry("genterra", TH_NATURAL),
				java.util.Map.entry("indus1", TH_NATURAL),
				java.util.Map.entry("indus2", TH_ANCIENT),
				java.util.Map.entry("indus3", TH_TECH),
				java.util.Map.entry("indus4", TH_TECH),
				java.util.Map.entry("indus5", TH_TECH),
				java.util.Map.entry("indus6", TH_ANCIENT),
				java.util.Map.entry("indus7", TH_TECH),
				java.util.Map.entry("lian-x", TH_TECH),
				java.util.Map.entry("metalmys", TH_INDUSTRIAL),
				java.util.Map.entry("mine", TH_SKAARJ_TECH),
				java.util.Map.entry("nalicast", TH_NALI_CASTLE),
				java.util.Map.entry("nalifX", TH_NALI_CASTLE),
				java.util.Map.entry("noxxpack", TH_INDUSTRIAL),
				java.util.Map.entry("old_fx", TH_NALI_TEMPLE),
				java.util.Map.entry("playrshp", TH_TECH),
				java.util.Map.entry("queen", TH_SKAARJ_TECH),
				java.util.Map.entry("rainfx", TH_INDUSTRIAL),
				java.util.Map.entry("richrig", TH_INDUSTRIAL),
				java.util.Map.entry("sgtech1", TH_TECH),
				java.util.Map.entry("anc", TH_ANCIENT),
				java.util.Map.entry("factory", TH_INDUSTRIAL),
				java.util.Map.entry("citytex", TH_CITY),
				java.util.Map.entry("a3text", TH_CITY),
				java.util.Map.entry("fluid", TH_NATURAL),
				java.util.Map.entry("anc2", TH_ANCIENT),
				java.util.Map.entry("hourindusx_ut", TH_INDUSTRIAL),
				java.util.Map.entry("hourpitores_ut", TH_INDUSTRIAL),
				java.util.Map.entry("wood", TH_INDUSTRIAL),
				java.util.Map.entry("quake3", TH_TECH),
				java.util.Map.entry("uttech4", TH_INDUSTRIAL),
				java.util.Map.entry("sscoldsteel", TH_TECH),
				java.util.Map.entry("quake3c", TH_TECH),
				java.util.Map.entry("ribeira3", TH_INDUSTRIAL),
				java.util.Map.entry("anc4", TH_ANCIENT),
				java.util.Map.entry("dino081199", TH_INDUSTRIAL),
				java.util.Map.entry("ribeira1", TH_INDUSTRIAL),
				java.util.Map.entry("ribeira2", TH_INDUSTRIAL),
				java.util.Map.entry("drmpa", TH_INDUSTRIAL),
				java.util.Map.entry("egyptian", TH_EGYPTIAN),
				java.util.Map.entry("uttech1", TH_INDUSTRIAL),
				java.util.Map.entry("braveheart", TH_ANCIENT),
				java.util.Map.entry("jump", TH_TECH),
				java.util.Map.entry("zeitkind", TH_INDUSTRIAL),
				java.util.Map.entry("houriceskaarj", TH_TECH),
				java.util.Map.entry("fallout", TH_INDUSTRIAL),
				java.util.Map.entry("castle", TH_ANCIENT),
				java.util.Map.entry("ambrosia", TH_NATURAL),
				java.util.Map.entry("chicoruinspack", TH_ANCIENT),
				java.util.Map.entry("gravdig", TH_ANCIENT),
				java.util.Map.entry("slums", TH_CITY),
				java.util.Map.entry("hourkraden_ut", TH_INDUSTRIAL),
				java.util.Map.entry("forsakent", TH_ANCIENT),

				java.util.Map.entry("urban", TH_CITY),
				java.util.Map.entry("blade", TH_CITY),
				java.util.Map.entry("vierheilig", TH_INDUSTRIAL),
				java.util.Map.entry("shanechurch", TH_ANCIENT),

				java.util.Map.entry("hourdinoratex", TH_INDUSTRIAL),
				java.util.Map.entry("r3tex", TH_ANCIENT),
				java.util.Map.entry("bentropical01", TH_NATURAL),

				/*
				  Unreal Tournament 2004
				*/
				java.util.Map.entry("humanoidarchitecture", TH_INDUSTRIAL),
				java.util.Map.entry("humanoidarchitecture2", TH_INDUSTRIAL),
				java.util.Map.entry("abaddonarchitecture", TH_INDUSTRIAL),
				java.util.Map.entry("abaddonarchitecture-tech", TH_INDUSTRIAL),
				java.util.Map.entry("shiptech", TH_TECH),
				java.util.Map.entry("shiptech2", TH_TECH),
				java.util.Map.entry("alleriaarchitecture", TH_TECH),
				java.util.Map.entry("barrensarchitecture", TH_EGYPTIAN),
				java.util.Map.entry("barrensarchitecture-epic", TH_EGYPTIAN),
				java.util.Map.entry("barrensarchitecture-scion", TH_EGYPTIAN),
				java.util.Map.entry("h_e_l_ltx", TH_ANCIENT),
				java.util.Map.entry("arboreaarchitecture", TH_ANCIENT),
				java.util.Map.entry("albatross_architecture", TH_ANCIENT),
				java.util.Map.entry("alleriaterrain", TH_NATURAL),
				java.util.Map.entry("phobos2_cp", TH_TECH),
				java.util.Map.entry("abaddonterrain", TH_NATURAL),
				java.util.Map.entry("barrensterrain", TH_NATURAL),
				java.util.Map.entry("cp_evil1", TH_TECH),
				java.util.Map.entry("cp_evil2", TH_TECH),
				java.util.Map.entry("cp_evil3", TH_TECH),
				java.util.Map.entry("sc_volcano_t", TH_NATURAL),
				java.util.Map.entry("antalustextures", TH_NATURAL),
				java.util.Map.entry("x_cp_evil1", TH_TECH),
				java.util.Map.entry("x_cp_evil2", TH_TECH),
				java.util.Map.entry("x_cp_evil3", TH_TECH),
				java.util.Map.entry("fareast", TH_ANCIENT),
				java.util.Map.entry("skyline-epic", TH_CITY),
				java.util.Map.entry("aw-metals", TH_INDUSTRIAL),
				java.util.Map.entry("aw-metals2", TH_INDUSTRIAL),
				java.util.Map.entry("aw-stone", TH_CITY),
				java.util.Map.entry("x_mechcity1_cp", TH_CITY),
				java.util.Map.entry("x_mechstandard", TH_TECH),
				java.util.Map.entry("towerterrain", TH_INDUSTRIAL),
				java.util.Map.entry("davestextures", TH_NATURAL),
				java.util.Map.entry("mech_decayed", TH_INDUSTRIAL),
				java.util.Map.entry("jwdecemberarchitecture", TH_INDUSTRIAL),
				java.util.Map.entry("c_sc-city", TH_CITY),
				java.util.Map.entry("despfallencity", TH_CITY),
				java.util.Map.entry("cp_ut2k3_techset1", TH_TECH),
				java.util.Map.entry("mechstandard", TH_TECH),
				java.util.Map.entry("cf_tex01", TH_TECH),
				java.util.Map.entry("cf_tex02", TH_TECH),
				java.util.Map.entry("cp_evilmetal", TH_TECH),
				java.util.Map.entry("hourmoria", TH_NATURAL),
				java.util.Map.entry("x_mech_decayed", TH_TECH),
				java.util.Map.entry("gaciertextures", TH_TECH),
				java.util.Map.entry("x_futuretech1", TH_TECH),
				java.util.Map.entry("futuretech1", TH_TECH),
				java.util.Map.entry("x_aw-convert", TH_NATURAL),
				java.util.Map.entry("pc_urbantex", TH_CITY),
				java.util.Map.entry("pipe_set", TH_INDUSTRIAL),
				java.util.Map.entry("2k4reducedtextures", TH_INDUSTRIAL),
				java.util.Map.entry("village", TH_ANCIENT),
				java.util.Map.entry("alientex", TH_TECH),
				java.util.Map.entry("xceptone", TH_TECH),
				java.util.Map.entry("xcepttwo", TH_TECH),
				java.util.Map.entry("xceptthree", TH_TECH),
				java.util.Map.entry("aw-citystuff", TH_CITY),
				java.util.Map.entry("industrial", TH_INDUSTRIAL),
				java.util.Map.entry("cp_forestswamp", TH_NATURAL),
				java.util.Map.entry("terrain", TH_NATURAL),
				java.util.Map.entry("cp_junkyard", TH_INDUSTRIAL)
		);
	}

	public static String findTheme(String packageName) {
		return THEMES.get(packageName.trim().toLowerCase());
	}

}
