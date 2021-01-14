package org.wltea.analyzer.dic;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;
import org.wltea.analyzer.cfg.Configuration;

public class DefaultConfig implements Configuration {
    private static final String PATH_DIC_MAIN = "org/wltea/analyzer/dic/main.dic";
    private static final String PATH_DIC_QUANTIFIER = "org/wltea/analyzer/dic/quantifier.dic";
    private static final String FILE_NAME = "IKAnalyzer.cfg.xml";
    private static final String EXT_DICT = "ext_dict";
    private static final String EXT_STOP = "ext_stopwords";
    private Properties props = new Properties();
    private boolean useSmart;

    public static Configuration getInstance() {
        return new DefaultConfig();
    }

    private DefaultConfig() {
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("IKAnalyzer.cfg.xml");
        if (input != null) {
            try {
                this.props.loadFromXML(input);
            } catch (InvalidPropertiesFormatException var3) {
                var3.printStackTrace();
            } catch (IOException var4) {
                var4.printStackTrace();
            }
        }

    }

    @Override
	public boolean useSmart() {
        return this.useSmart;
    }

    public void setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
    }

    public String getMainDictionary() {
        return "org/wltea/analyzer/dic/main2012.dic";
    }

    public String getQuantifierDicionary() {
        return "org/wltea/analyzer/dic/quantifier.dic";
    }

    public List<String> getExtDictionarys() {
        List<String> extDictFiles = new ArrayList(2);
        String extDictCfg = this.props.getProperty("ext_dict");
        if (extDictCfg != null) {
            String[] filePaths = extDictCfg.split(";");
            if (filePaths != null) {
                String[] var4 = filePaths;
                int var5 = filePaths.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    String filePath = var4[var6];
                    if (filePath != null && !"".equals(filePath.trim())) {
                        extDictFiles.add(filePath.trim());
                    }
                }
            }
        }

        return extDictFiles;
    }

    public List<String> getExtStopWordDictionarys() {
        List<String> extStopWordDictFiles = new ArrayList(2);
        String extStopWordDictCfg = this.props.getProperty("ext_stopwords");
        if (extStopWordDictCfg != null) {
            String[] filePaths = extStopWordDictCfg.split(";");
            if (filePaths != null) {
                String[] var4 = filePaths;
                int var5 = filePaths.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    String filePath = var4[var6];
                    if (filePath != null && !"".equals(filePath.trim())) {
                        extStopWordDictFiles.add(filePath.trim());
                    }
                }
            }
        }

        return extStopWordDictFiles;
    }
}
