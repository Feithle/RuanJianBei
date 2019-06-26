package SpiterUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.http.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Bean.DataBean;
import Bean.DataBeansForSort;
import Bean.HtmlBean;
import DaoForLocalDataBase.UserDaoImpl;

/**
 * 
 *
 * return list
 */
public class ParseHtml {
 
    public static ArrayList<DataBeansForSort> parserHtml(String url) throws ParseException, IOException {
    	ArrayList<DataBeansForSort> dataBeansForSorts =new ArrayList<DataBeansForSort>();
    		String content =Stock.getHtmlByUrl(url);
    		Document doc = Jsoup.parse(content, "utf-8");
    		String id="";//
    		String content1="";//
    		Elements trs= doc.getElementsByTag("tr");
    		int i=1;
    		for(Element tr:trs) {
    			DataBeansForSort dataBeansForSort=new DataBeansForSort();
    			Elements tds=tr.getElementsByTag("td");
    			for(Element td:tds) {//only one time
    				id=td.firstElementSibling().text();
    				dataBeansForSort.setId(Integer.parseInt(id));
    				content1=td.lastElementSibling().text();
    				dataBeansForSort.setContent(content1);
    			}
        		dataBeansForSorts.add(dataBeansForSort);
    	
    		}
            for (int h = 0; h < dataBeansForSorts.size(); h++) {
                for (int j = h; j < dataBeansForSorts.size(); j++) {
                    if (dataBeansForSorts.get(h).getId() >= dataBeansForSorts.get(j).getId()) {
                    	 Collections.swap(dataBeansForSorts, h, j);
                    }
                }
            }
        return dataBeansForSorts;
    }
    public static void input(String url) {

    	ArrayList<DataBeansForSort> dataBeansForSorts =new ArrayList<DataBeansForSort>();
    	try {
    		dataBeansForSorts=ParseHtml.parserHtml(url);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("inserting the data into database ……");
    	for(DataBeansForSort dataBeansForSort:dataBeansForSorts) {
    		HtmlBean htmlBean=new HtmlBean();
    		htmlBean.setId(String.valueOf(dataBeansForSort.getId()));
    		htmlBean.setContent(dataBeansForSort.getContent());
    		UserDaoImpl.add(htmlBean);
    		}
    	System.out.println("done");
    }
}

