package MacUtil;
import java.net.InetAddress;
import java.net.NetworkInterface;

public class GetMac {
      /**
     * @return
     * TODO get the mac address using this code
     */
    public String GetMac()
      {
          InetAddress ia;
          byte[] mac = null;
        try {
            ia = InetAddress.getLocalHost();
            mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();  
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          StringBuffer sb = new StringBuffer();  
          for(int i=0;i<mac.length;i++){  
              if(i!=0){  
                  sb.append("-");  
              }  
              String s = Integer.toHexString(mac[i] & 0xFF);  
              sb.append(s.length()==1?0+s:s);  
          }  
          return sb.toString().toUpperCase();
      }
      public static void main(String[] args)
      {
          GetMac t=new GetMac();
           String mac=t.GetMac();
          System.out.println(mac);
      } 
}
