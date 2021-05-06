package configuration;

import org.apache.logging.log4j.LogManager;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class LocalWebDriverProperties {
    //W klasie znajduje się tylko jedna metoda. Służy ona do odczytywania właściwości z zadanego pliku properties
    private Logger logger = LogManager.getLogger(PropertiesLoader.class);

    public Properties getPropertiesFromFile(String propertiesFileName) {

        // Utworzenie obiektu InputStream służacy do odczytania pliku properties
        InputStream inputStream = null;

        //Obiekt Properties będzie przechowywał właściwości
        Properties properties = new Properties();
        try {
            logger.info("Trying to load propertis with file name: " + propertiesFileName);

            //Odczytujemy plik properties i inicjalizujemy obiekt inputStream
            inputStream.getClass().getClassLoader().getResourceAsStream(propertiesFileName);

            //Jeśli plik properties by nie istniał, obiekt inputStream będzie null-em. W związku z czym
            // zostanie rzucony wyjątek FileNotFoundException

            if (inputStream!=null){
                // ładujemy 
            }


    }
}
