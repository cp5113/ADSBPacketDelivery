package elements;

import java.text.SimpleDateFormat;
import java.util.Date;

import json.sample.ADSBSAMPLEJson;
import json.sample.JsonParserSJ;

import java.lang.module.ModuleDescriptor.Exports.Modifier;
import java.lang.reflect.Field;

public class Aircraft {
	private int 				uti; // Linux timestamp of last message "uti":1435477011
	private	Date				dat; // ESRI formatted timestamp of last message "dat":"2015-07-26 07:36:51.657189000"
	private	Date				tim; // Time of last message (contains nanoseconds) "tim":"07:36:51.657189000""
	private	String 				hex; // ICAO Aircraft Hex ID
	private String				fli; // Flight Identification/Call Sign
	private double				lat; // Latitude (WGS-84)
	private double 				lon; // Longitude (WGS-84)
	private String				gda; // Ground/Air status A=Air G=GND
	private String				src; // Source of position*
	private int					alt; // Altitude (Flight level)
	private short				spd; // Ground Speed
	private short				trk; // True track
	private String				cat; // Category (A0-C7)
	private String				org; // Origin
	private String				des; // Destination
	private String				opr; // Operator
	private String				typ; // Type
	private String				reg; // Registration
	private short				squ; // Squawk
	private String				cou; // Country 
	private float				dis; // Distance from station position
	private int					tru; //  Trust Level
	private int					vrt; // Vertical Rate in ft/min
	private int					mch; // MACH* in MACH x 100 optional
	private int					ias; // IAS* in kts optional
	private int					tas; // TAS* in kts optional
	private int					rol; // Roll angle* in degrees/sec optional
	private int					tra; // Turn rate* in degrees/sec optional
	private int					sfl; // Sel FL* in ft Flight Level optional
	private int					qnh; // QNH* in hPa optional
	private int					shd; // Sel Heading* in degrees magnetic optional
	private int					hgt; // Height difference* between FL and GPS ellipsoid optional
	private int					mop; // MOPS* Transponder standard optional
	private int					flg; // Alert, SPI, Emerg.,IC* Transponder flags optional
	private int					tcs; // TCAS alert* TCAS alert optional
	private int					nic; // NIC + NACV* Transponder precision data optional
	private int					apm; // autopilot mode* optional
	private int					rec; // record number internal
	private int					lla; // LatLon_Age Age of ADS-B last position packet in sec
	private int					lpa; // LastPacket_Age* Age of last ADS-B or Mode-S packet in sec optional
	private int					tsa; // Track Size ADS-B internal
	private int					tsm=1; // Track Size MLAT internal
	
	public Aircraft(String aJson) {
		JsonParserSJ.parsingJsonWithDelaredFieldsInClass(this,aJson);
	}
	
	public Aircraft() {
		
	}
	

	
	@SuppressWarnings("unused")
//	public static void main(String args[]) {
//		
//		ADSBSAMPLEJson data = new ADSBSAMPLEJson();
//		Aircraft a 			= new Aircraft("[{\\\"uti\\\":1550623903,\\\"dat\\\":\\\"2019-02-20 00:51:43.690854937\\\",\\\"tim\\\":\\\"00:51:43.690854937\\\",\\\"hex\\\":\\\"71C325\\\",\\\"fli\\\":\\\"\\\",\\\"lat\\\":\\\"36.76435\\\",\\\"lon\\\":\\\"127.24049\\\",\\\"gda\\\":\\\"A\\\",\\\"src\\\":\\\"A\\\",\\\"alt\\\":9700,\\\"spd\\\":313,\\\"trk\\\":50,\\\"cat\\\":\\\"\\\",\\\"org\\\":\\\"\\\",\\\"dst\\\":\\\"\\\",\\\"opr\\\":\\\"\\\",\\\"typ\\\":\\\"\\\",\\\"reg\\\":\\\"\\\",\\\"dis\\\":\\\"98.5\\\",\\\"dbm\\\":-93,\\\"cou\\\":\\\"SKor\\\",\\\"squ\\\":\\\"7210\\\",\\\"tru\\\":23,\\\"tsa\\\":2,\\\"tsm\\\":0,\\\"vrt\\\":-576,\\\"lla\\\":1},\\r\\n\"");
//		
//	}
	

	public synchronized int getUti() {
		return uti;
	}

	public synchronized void setUti(int uti) {
		this.uti = uti;
	}

	public synchronized Date getDat() {
		return dat;
	}

	public synchronized void setDat(Date dat) {
		this.dat = dat;
	}

	public synchronized Date getTim() {
		return tim;
	}

	public synchronized void setTim(Date tim) {
		this.tim = tim;
	}

	public synchronized String getHex() {
		return hex;
	}

	public synchronized void setHex(String hex) {
		this.hex = hex;
	}

	public synchronized String getFli() {
		return fli;
	}

	public synchronized void setFli(String fli) {
		this.fli = fli;
	}

	public synchronized double getLat() {
		return lat;
	}

	public synchronized void setLat(double lat) {
		this.lat = lat;
	}

	public synchronized double getLon() {
		return lon;
	}

	public synchronized void setLon(double lon) {
		this.lon = lon;
	}

	public synchronized String getGda() {
		return gda;
	}

	public synchronized void setGda(String gda) {
		this.gda = gda;
	}

	public synchronized String getSrc() {
		return src;
	}

	public synchronized void setSrc(String src) {
		this.src = src;
	}

	public synchronized int getAlt() {
		return alt;
	}

	public synchronized void setAlt(int alt) {
		this.alt = alt;
	}

	public synchronized short getSpd() {
		return spd;
	}

	public synchronized void setSpd(short spd) {
		this.spd = spd;
	}

	public synchronized short getTrk() {
		return trk;
	}

	public synchronized void setTrk(short trk) {
		this.trk = trk;
	}

	public synchronized String getCat() {
		return cat;
	}

	public synchronized void setCat(String cat) {
		this.cat = cat;
	}

	public synchronized String getOrg() {
		return org;
	}

	public synchronized void setOrg(String org) {
		this.org = org;
	}

	public synchronized String getDes() {
		return des;
	}

	public synchronized void setDes(String des) {
		this.des = des;
	}

	public synchronized String getOpr() {
		return opr;
	}

	public synchronized void setOpr(String opr) {
		this.opr = opr;
	}

	public synchronized String getTyp() {
		return typ;
	}

	public synchronized void setTyp(String typ) {
		this.typ = typ;
	}

	public synchronized String getReg() {
		return reg;
	}

	public synchronized void setReg(String reg) {
		this.reg = reg;
	}

	public synchronized short getSqu() {
		return squ;
	}

	public synchronized void setSqu(short squ) {
		this.squ = squ;
	}

	public synchronized String getCou() {
		return cou;
	}

	public synchronized void setCou(String cou) {
		this.cou = cou;
	}

	public synchronized float getDis() {
		return dis;
	}

	public synchronized void setDis(float dis) {
		this.dis = dis;
	}

	public synchronized int getTru() {
		return tru;
	}

	public synchronized void setTru(int tru) {
		this.tru = tru;
	}

	public synchronized int getVrt() {
		return vrt;
	}

	public synchronized void setVrt(int vrt) {
		this.vrt = vrt;
	}

	public synchronized int getMch() {
		return mch;
	}

	public synchronized void setMch(int mch) {
		this.mch = mch;
	}

	public synchronized int getIas() {
		return ias;
	}

	public synchronized void setIas(int ias) {
		this.ias = ias;
	}

	public synchronized int getTas() {
		return tas;
	}

	public synchronized void setTas(int tas) {
		this.tas = tas;
	}

	public synchronized int getRol() {
		return rol;
	}

	public synchronized void setRol(int rol) {
		this.rol = rol;
	}

	public synchronized int getTra() {
		return tra;
	}

	public synchronized void setTra(int tra) {
		this.tra = tra;
	}

	public synchronized int getSfl() {
		return sfl;
	}

	public synchronized void setSfl(int sfl) {
		this.sfl = sfl;
	}

	public synchronized int getQnh() {
		return qnh;
	}

	public synchronized void setQnh(int qnh) {
		this.qnh = qnh;
	}

	public synchronized int getShd() {
		return shd;
	}

	public synchronized void setShd(int shd) {
		this.shd = shd;
	}

	public synchronized int getHgt() {
		return hgt;
	}

	public synchronized void setHgt(int hgt) {
		this.hgt = hgt;
	}

	public synchronized int getMop() {
		return mop;
	}

	public synchronized void setMop(int mop) {
		this.mop = mop;
	}

	public synchronized int getFlg() {
		return flg;
	}

	public synchronized void setFlg(int flg) {
		this.flg = flg;
	}

	public synchronized int getTcs() {
		return tcs;
	}

	public synchronized void setTcs(int tcs) {
		this.tcs = tcs;
	}

	public synchronized int getNic() {
		return nic;
	}

	public synchronized void setNic(int nic) {
		this.nic = nic;
	}

	public synchronized int getApm() {
		return apm;
	}

	public synchronized void setApm(int apm) {
		this.apm = apm;
	}

	public synchronized int getRec() {
		return rec;
	}

	public synchronized void setRec(int rec) {
		this.rec = rec;
	}

	public synchronized int getLla() {
		return lla;
	}

	public synchronized void setLla(int lla) {
		this.lla = lla;
	}

	public synchronized int getLpa() {
		return lpa;
	}

	public synchronized void setLpa(int lpa) {
		this.lpa = lpa;
	}

	public synchronized int getTsa() {
		return tsa;
	}

	public synchronized void setTsa(int tsa) {
		this.tsa = tsa;
	}

	public synchronized int getTsm() {
		return tsm;
	}

	public synchronized void setTsm(int tsm) {
		this.tsm = tsm;
	}
	
	
	
}
