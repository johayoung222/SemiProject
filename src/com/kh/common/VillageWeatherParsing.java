package com.kh.common;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class VillageWeatherParsing {
	
	public void getVillageWeather(/*String baseDate, String baseTime*/) {
		  try{
	          /*요청정보입력
	           * 아래와 같은 정보들은 사용자 가이드를 확인하여 찾아주시면 됩니다.
	           * 위도 경도는 엑셀파일 안에 있습니다.
	           * */
	           
	            //자신이 조회를 원하는 지역의 경도와 위도를 입력해주세요
	            String nx = "92";  //경도
	            String ny = "131";   //위도
	            String baseDate = "20180502"; // 자신이 조회하고싶은 날짜를 입력해주세요
	            String baseTime = "0500"; //자신이 조회하고싶은 시간대를 입력해주세요
	            // 서비스 인증키입니다. 공공데이터포털에서 제공해준 인증키를 넣어주시면 됩니다.
	            String serviceKey = "개인별로 받은 인증키를 넣어주세요";
	             
	            // 정보를 모아서 URL정보를 만들면됩니다. 맨 마지막 "&_type=json"에 따라 반환 데이터의 형태가 정해집니다.
	            String urlStr = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData?"
	                + "serviceKey=" + serviceKey + "&base_date=" + baseDate + "&base_time=" + baseTime
	                + "&nx="+ nx + "&ny=" + ny + "&_type=json";
	            URL url = new URL(urlStr); // 위 urlStr을 이용해서 URL 객체를 만들어줍니다.
	            BufferedReader bf;
	            String line = "";
	            String result="";
	 
	            //날씨 정보를 받아옵니다.
	            bf = new BufferedReader(new InputStreamReader(url.openStream()));
	 
	            //버퍼에 있는 정보를 하나의 문자열로 변환.
	            while((line=bf.readLine())!=null){
	                result=result.concat(line);
	               // System.out.println(result);  // 받아온 데이터를 확인해봅니다.
	            }
	            
	             // Json parser를 만들어 만들어진 문자열 데이터를 객체화 합니다.
	        JSONParser parser = new JSONParser();
	        JSONObject obj = (JSONObject) parser.parse(result);
	         
	        // Top레벨 단계인 response 키를 가지고 데이터를 파싱합니다.
	        JSONObject parse_response = (JSONObject) obj.get("response");
	        // response 로 부터 body 찾아옵니다.
	        JSONObject parse_body = (JSONObject) parse_response.get("body");
	        // body 로 부터 items 받아옵니다.
	        JSONObject parse_items = (JSONObject) parse_body.get("items");
	         
	        // items로 부터 itemlist 를 받아오기 itemlist : 뒤에 [ 로 시작하므로 jsonarray이다
	        JSONArray parse_item = (JSONArray) parse_items.get("item");
	         
	        String category;
	        JSONObject weather; // parse_item은 배열형태이기 때문에 하나씩 데이터를 하나씩 가져올때 사용합니다.
	 
	        // 필요한 데이터만 가져오려고합니다.
	        for(int i = 0 ; i < parse_item.size(); i++)
	        {
	          weather = (JSONObject) parse_item.get(i);
	          //String base_Date = (String)weather.get("baseDate");
	          //String fcst_Time = (String)weather.get("fcstDate");
	          double fcst_Value = ((Long)weather.get("fcstValue")).doubleValue(); //실수로된 값과 정수로된 값이 둘다 있어서 실수로 통일했습니다.
	          //String nX = (String)weather.get("nx");
	          //String nY = (String)weather.get("ny");
	          category = (String)weather.get("category");
	          //String base_Time = (String)weather.get("baseTime");
	          //String fcscDate = (String)weather.get("fcscDate");
	           
	          // 출력합니다.
	          System.out.print("배열의 "+i+"번째 요소");
	          System.out.print("   category : "+ category);
	          System.out.print("   fcst_Value : "+ fcst_Value);
	          System.out.println();
	        }
	        // 마지막에보면 에러가 발생하였는데 casting문제입니다.
	        // 이는 반환되는 데이터타입이 달라서인데 이번 글에서는 여기까지만하고
	        // 데이터베이스에 입력할때는 수정해서 하겠습니다.
	         
	 
	            bf.close();
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	        }
	}
	
	
}
