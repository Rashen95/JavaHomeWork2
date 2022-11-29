//Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
//Данные для фильтрации приведены ниже в виде json строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Task01 {
    public static void main(String[] args) throws ParseException {
        String json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        StringBuilder myBuilder = new StringBuilder();
        myBuilder.append("select * from students where ");
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(json);
        System.out.println(jsonObject);


        String name = (String) jsonObject.get("name");
        if (!name.equals("null")) {
            myBuilder.append("name = ");
            myBuilder.append(name);
        }
        String country = (String) jsonObject.get("country");
        if (!country.equals("null")) {
            myBuilder.append(" and ");
            myBuilder.append("country = ");
            myBuilder.append(country);
        }
        String city = (String) jsonObject.get("city");
        if (!city.equals("null")) {
            myBuilder.append(" and ");
            myBuilder.append("city = ");
            myBuilder.append(city);

        }
        String age = (String) jsonObject.get("age");
        if (!age.equals("null")) {
            myBuilder.append(" and ");
            myBuilder.append("age = ");
            myBuilder.append(age);
        }
        System.out.println(myBuilder);
    }
}
