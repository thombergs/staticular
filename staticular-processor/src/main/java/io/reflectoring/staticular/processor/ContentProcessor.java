package io.reflectoring.staticular.processor;

import io.reflectoring.staticular.spi.model.StaticFile;
import io.reflectoring.staticular.spi.model.UserContent;

public class ContentProcessor {

  public void processUserContent(UserContent userContent, SiteConfiguration siteConfiguration){
    StaticFile staticFile = siteConfiguration.transformer().transformContent(userContent);
    siteConfiguration.publisher().publishContent(staticFile);
  }

}
