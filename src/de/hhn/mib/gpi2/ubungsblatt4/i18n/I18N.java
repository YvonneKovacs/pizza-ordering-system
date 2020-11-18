package de.hhn.mib.gpi2.ubungsblatt4.i18n;

import java.util.Locale;
import java.util.ResourceBundle;


public class I18N {
    private static ResourceBundle messages = ResourceBundle.getBundle("de.hhn.mib.gpi2.ubungsblatt4.i18n.MessageBundle",Locale.US);

    public I18N(){
        //messages= ResourceBundle.getBundle("de.hhn.mib.gpi2.ubungsblatt4.i18n.MessageBundle",new Locale("de","DE"));
        ///messages = ResourceBundle.getBundle("de.hhn.mib.gpi2.ubungsblatt4.i18n.MessageBundle_de_DE");
    }


    public static String getMessage(String label){
        return messages.getString(label);
    }

   public static void setLocale(Locale currentLocale){
            messages= ResourceBundle.getBundle("de.hhn.mib.gpi2.ubungsblatt4.i18n.MessageBundle",currentLocale);
    }

}
