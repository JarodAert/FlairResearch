package org.json;

import java.io.PrintStream;
import java.io.StringWriter;
import java.util.Iterator;

public class Test
{
  public Test() {}
  
  public static void main(String[] paramArrayOfString)
  {
    JSONString local1Obj = new JSONString()
    {
      public boolean aBoolean;
      public double aNumber;
      
      public String getBENT()
      {
        return "All uppercase key";
      }
      
      public double getNumber()
      {
        return aNumber;
      }
      
      public String getString()
      {
        return Test.this;
      }
      
      public String getX()
      {
        return "x";
      }
      
      public boolean isBoolean()
      {
        return aBoolean;
      }
      
      public String toJSONString()
      {
        return "{" + JSONObject.quote(Test.this) + ":" + JSONObject.doubleToString(aNumber) + "}";
      }
      
      public String toString()
      {
        return getString() + " " + getNumber() + " " + isBoolean() + "." + getBENT() + " " + getX();
      }
    };
    try
    {
      JSONObject localJSONObject1 = XML.toJSONObject("<![CDATA[This is a collection of test patterns and examples for org.json.]]>  Ignore the stuff past the end.  ");
      System.out.println(localJSONObject1.toString());
      JSONObject localJSONObject2 = new JSONObject("{     \"list of lists\" : [         [1, 2, 3],         [4, 5, 6],     ] }");
      System.out.println(localJSONObject2.toString(4));
      System.out.println(XML.toString(localJSONObject2));
      JSONObject localJSONObject3 = XML.toJSONObject("<recipe name=\"bread\" prep_time=\"5 mins\" cook_time=\"3 hours\"> <title>Basic bread</title> <ingredient amount=\"8\" unit=\"dL\">Flour</ingredient> <ingredient amount=\"10\" unit=\"grams\">Yeast</ingredient> <ingredient amount=\"4\" unit=\"dL\" state=\"warm\">Water</ingredient> <ingredient amount=\"1\" unit=\"teaspoon\">Salt</ingredient> <instructions> <step>Mix all ingredients together.</step> <step>Knead thoroughly.</step> <step>Cover with a cloth, and leave for one hour in warm room.</step> <step>Knead again.</step> <step>Place in a bread baking tin.</step> <step>Cover with a cloth, and leave for one hour in warm room.</step> <step>Bake in the oven at 180(degrees)C for 30 minutes.</step> </instructions> </recipe> ");
      System.out.println(localJSONObject3.toString(4));
      System.out.println();
      JSONObject localJSONObject4 = JSONML.toJSONObject("<recipe name=\"bread\" prep_time=\"5 mins\" cook_time=\"3 hours\"> <title>Basic bread</title> <ingredient amount=\"8\" unit=\"dL\">Flour</ingredient> <ingredient amount=\"10\" unit=\"grams\">Yeast</ingredient> <ingredient amount=\"4\" unit=\"dL\" state=\"warm\">Water</ingredient> <ingredient amount=\"1\" unit=\"teaspoon\">Salt</ingredient> <instructions> <step>Mix all ingredients together.</step> <step>Knead thoroughly.</step> <step>Cover with a cloth, and leave for one hour in warm room.</step> <step>Knead again.</step> <step>Place in a bread baking tin.</step> <step>Cover with a cloth, and leave for one hour in warm room.</step> <step>Bake in the oven at 180(degrees)C for 30 minutes.</step> </instructions> </recipe> ");
      System.out.println(localJSONObject4.toString());
      System.out.println(JSONML.toString(localJSONObject4));
      System.out.println();
      JSONArray localJSONArray1 = JSONML.toJSONArray("<recipe name=\"bread\" prep_time=\"5 mins\" cook_time=\"3 hours\"> <title>Basic bread</title> <ingredient amount=\"8\" unit=\"dL\">Flour</ingredient> <ingredient amount=\"10\" unit=\"grams\">Yeast</ingredient> <ingredient amount=\"4\" unit=\"dL\" state=\"warm\">Water</ingredient> <ingredient amount=\"1\" unit=\"teaspoon\">Salt</ingredient> <instructions> <step>Mix all ingredients together.</step> <step>Knead thoroughly.</step> <step>Cover with a cloth, and leave for one hour in warm room.</step> <step>Knead again.</step> <step>Place in a bread baking tin.</step> <step>Cover with a cloth, and leave for one hour in warm room.</step> <step>Bake in the oven at 180(degrees)C for 30 minutes.</step> </instructions> </recipe> ");
      System.out.println(localJSONArray1.toString(4));
      System.out.println(JSONML.toString(localJSONArray1));
      System.out.println();
      JSONObject localJSONObject5 = JSONML.toJSONObject("<div id=\"demo\" class=\"JSONML\"><p>JSONML is a transformation between <b>JSON</b> and <b>XML</b> that preserves ordering of document features.</p><p>JSONML can work with JSON arrays or JSON objects.</p><p>Three<br/>little<br/>words</p></div>");
      System.out.println(localJSONObject5.toString(4));
      System.out.println(JSONML.toString(localJSONObject5));
      System.out.println();
      JSONArray localJSONArray2 = JSONML.toJSONArray("<div id=\"demo\" class=\"JSONML\"><p>JSONML is a transformation between <b>JSON</b> and <b>XML</b> that preserves ordering of document features.</p><p>JSONML can work with JSON arrays or JSON objects.</p><p>Three<br/>little<br/>words</p></div>");
      System.out.println(localJSONArray2.toString(4));
      System.out.println(JSONML.toString(localJSONArray2));
      System.out.println();
      JSONObject localJSONObject6 = XML.toJSONObject("<person created=\"2006-11-11T19:23\" modified=\"2006-12-31T23:59\">\n <firstName>Robert</firstName>\n <lastName>Smith</lastName>\n <address type=\"home\">\n <street>12345 Sixth Ave</street>\n <city>Anytown</city>\n <state>CA</state>\n <postalCode>98765-4321</postalCode>\n </address>\n </person>");
      System.out.println(localJSONObject6.toString(4));
      JSONObject localJSONObject7 = new JSONObject(local1Obj);
      System.out.println(localJSONObject7.toString());
      JSONObject localJSONObject8 = new JSONObject("{ \"entity\": { \"imageURL\": \"\", \"name\": \"IXXXXXXXXXXXXX\", \"id\": 12336, \"ratingCount\": null, \"averageRating\": null } }");
      System.out.println(localJSONObject8.toString(2));
      String str1 = new JSONStringer().object().key("single").value("MARIE HAA'S").key("Johnny").value("MARIE HAA\\'S").key("foo").value("bar").key("baz").array().object().key("quux").value("Thanks, Josh!").endObject().endArray().key("obj keys").value(JSONObject.getNames(local1Obj)).endObject().toString();
      System.out.println(str1);
      System.out.println(new JSONStringer().object().key("a").array().array().array().value("b").endArray().endArray().endArray().endObject().toString());
      JSONStringer localJSONStringer = new JSONStringer();
      localJSONStringer.array();
      localJSONStringer.value(1L);
      localJSONStringer.array();
      localJSONStringer.value(null);
      localJSONStringer.array();
      localJSONStringer.object();
      localJSONStringer.key("empty-array").array().endArray();
      localJSONStringer.key("answer").value(42L);
      localJSONStringer.key("null").value(null);
      localJSONStringer.key("false").value(false);
      localJSONStringer.key("true").value(true);
      localJSONStringer.key("big").value(1.23456789E96D);
      localJSONStringer.key("small").value(1.23456789E-80D);
      localJSONStringer.key("empty-object").object().endObject();
      localJSONStringer.key("long");
      localJSONStringer.value(Long.MAX_VALUE);
      localJSONStringer.endObject();
      localJSONStringer.value("two");
      localJSONStringer.endArray();
      localJSONStringer.value(true);
      localJSONStringer.endArray();
      localJSONStringer.value(98.6D);
      localJSONStringer.value(-100.0D);
      localJSONStringer.object();
      localJSONStringer.endObject();
      localJSONStringer.object();
      localJSONStringer.key("one");
      localJSONStringer.value(1.0D);
      localJSONStringer.endObject();
      localJSONStringer.value(local1Obj);
      localJSONStringer.endArray();
      System.out.println(localJSONStringer.toString());
      System.out.println(new JSONArray(localJSONStringer.toString()).toString(4));
      JSONArray localJSONArray3 = new JSONArray(new int[] { 1, 2, 3 });
      System.out.println(localJSONArray3.toString());
      JSONObject localJSONObject9 = new JSONObject(local1Obj, new String[] { "aString", "aNumber", "aBoolean" });
      localJSONObject9.put("Testing JSONString interface", local1Obj);
      System.out.println(localJSONObject9.toString(4));
      JSONObject localJSONObject10 = new JSONObject("{slashes: '///', closetag: '</script>', backslash:'\\\\', ei: {quotes: '\"\\''},eo: {a: '\"quoted\"', b:\"don't\"}, quotes: [\"'\", '\"']}");
      System.out.println(localJSONObject10.toString(2));
      System.out.println(XML.toString(localJSONObject10));
      System.out.println("");
      JSONObject localJSONObject11 = new JSONObject("{foo: [true, false,9876543210,    0.0, 1.00000001,  1.000000000001, 1.00000000000000001, .00000000000000001, 2.00, 0.1, 2e100, -32,[],{}, \"string\"],   to   : null, op : 'Good',ten:10} postfix comment");
      localJSONObject11.put("String", "98.6");
      localJSONObject11.put("JSONObject", new JSONObject());
      localJSONObject11.put("JSONArray", new JSONArray());
      localJSONObject11.put("int", 57);
      localJSONObject11.put("double", 1.2345678901234568E29D);
      localJSONObject11.put("true", true);
      localJSONObject11.put("false", false);
      localJSONObject11.put("null", JSONObject.NULL);
      localJSONObject11.put("bool", "true");
      localJSONObject11.put("zero", 0.0D);
      localJSONObject11.put("\\u2028", " ");
      localJSONObject11.put("\\u2029", " ");
      JSONArray localJSONArray4 = localJSONObject11.getJSONArray("foo");
      localJSONArray4.put(666);
      localJSONArray4.put(2001.99D);
      localJSONArray4.put("so \"fine\".");
      localJSONArray4.put("so <fine>.");
      localJSONArray4.put(true);
      localJSONArray4.put(false);
      localJSONArray4.put(new JSONArray());
      localJSONArray4.put(new JSONObject());
      localJSONObject11.put("keys", JSONObject.getNames(localJSONObject11));
      System.out.println(localJSONObject11.toString(4));
      System.out.println(XML.toString(localJSONObject11));
      System.out.println("String: " + localJSONObject11.getDouble("String"));
      System.out.println("  bool: " + localJSONObject11.getBoolean("bool"));
      System.out.println("    to: " + localJSONObject11.getString("to"));
      System.out.println("  true: " + localJSONObject11.getString("true"));
      System.out.println("   foo: " + localJSONObject11.getJSONArray("foo"));
      System.out.println("    op: " + localJSONObject11.getString("op"));
      System.out.println("   ten: " + localJSONObject11.getInt("ten"));
      System.out.println("  oops: " + localJSONObject11.optBoolean("oops"));
      JSONObject localJSONObject12 = XML.toJSONObject("<xml one = 1 two=' \"2\" '><five></five>First \t&lt;content&gt;<five></five> This is \"content\". <three>  3  </three>JSON does not preserve the sequencing of elements and contents.<three>  III  </three>  <three>  T H R E E</three><four/>Content text is an implied structure in XML. <six content=\"6\"/>JSON does not have implied structure:<seven>7</seven>everything is explicit.<![CDATA[CDATA blocks<are><supported>!]]></xml>");
      System.out.println(localJSONObject12.toString(2));
      System.out.println(XML.toString(localJSONObject12));
      System.out.println("");
      JSONArray localJSONArray5 = JSONML.toJSONArray("<xml one = 1 two=' \"2\" '><five></five>First \t&lt;content&gt;<five></five> This is \"content\". <three>  3  </three>JSON does not preserve the sequencing of elements and contents.<three>  III  </three>  <three>  T H R E E</three><four/>Content text is an implied structure in XML. <six content=\"6\"/>JSON does not have implied structure:<seven>7</seven>everything is explicit.<![CDATA[CDATA blocks<are><supported>!]]></xml>");
      System.out.println(localJSONArray5.toString(4));
      System.out.println(JSONML.toString(localJSONArray5));
      System.out.println("");
      JSONArray localJSONArray6 = JSONML.toJSONArray("<xml do='0'>uno<a re='1' mi='2'>dos<b fa='3'/>tres<c>true</c>quatro</a>cinqo<d>seis<e/></d></xml>");
      System.out.println(localJSONArray6.toString(4));
      System.out.println(JSONML.toString(localJSONArray6));
      System.out.println("");
      JSONObject localJSONObject13 = XML.toJSONObject("<mapping><empty/>   <class name = \"Customer\">      <field name = \"ID\" type = \"string\">         <bind-xml name=\"ID\" node=\"attribute\"/>      </field>      <field name = \"FirstName\" type = \"FirstName\"/>      <field name = \"MI\" type = \"MI\"/>      <field name = \"LastName\" type = \"LastName\"/>   </class>   <class name = \"FirstName\">      <field name = \"text\">         <bind-xml name = \"text\" node = \"text\"/>      </field>   </class>   <class name = \"MI\">      <field name = \"text\">         <bind-xml name = \"text\" node = \"text\"/>      </field>   </class>   <class name = \"LastName\">      <field name = \"text\">         <bind-xml name = \"text\" node = \"text\"/>      </field>   </class></mapping>");
      System.out.println(localJSONObject13.toString(2));
      System.out.println(XML.toString(localJSONObject13));
      System.out.println("");
      JSONArray localJSONArray7 = JSONML.toJSONArray("<mapping><empty/>   <class name = \"Customer\">      <field name = \"ID\" type = \"string\">         <bind-xml name=\"ID\" node=\"attribute\"/>      </field>      <field name = \"FirstName\" type = \"FirstName\"/>      <field name = \"MI\" type = \"MI\"/>      <field name = \"LastName\" type = \"LastName\"/>   </class>   <class name = \"FirstName\">      <field name = \"text\">         <bind-xml name = \"text\" node = \"text\"/>      </field>   </class>   <class name = \"MI\">      <field name = \"text\">         <bind-xml name = \"text\" node = \"text\"/>      </field>   </class>   <class name = \"LastName\">      <field name = \"text\">         <bind-xml name = \"text\" node = \"text\"/>      </field>   </class></mapping>");
      System.out.println(localJSONArray7.toString(4));
      System.out.println(JSONML.toString(localJSONArray7));
      System.out.println("");
      JSONObject localJSONObject14 = XML.toJSONObject("<?xml version=\"1.0\" ?><Book Author=\"Anonymous\"><Title>Sample Book</Title><Chapter id=\"1\">This is chapter 1. It is not very long or interesting.</Chapter><Chapter id=\"2\">This is chapter 2. Although it is longer than chapter 1, it is not any more interesting.</Chapter></Book>");
      System.out.println(localJSONObject14.toString(2));
      System.out.println(XML.toString(localJSONObject14));
      System.out.println("");
      JSONObject localJSONObject15 = XML.toJSONObject("<!DOCTYPE bCard 'http://www.cs.caltech.edu/~adam/schemas/bCard'><bCard><?xml default bCard        firstname = ''        lastname  = '' company   = '' email = '' homepage  = ''?><bCard        firstname = 'Rohit'        lastname  = 'Khare'        company   = 'MCI'        email     = 'khare@mci.net'        homepage  = 'http://pest.w3.org/'/><bCard        firstname = 'Adam'        lastname  = 'Rifkin'        company   = 'Caltech Infospheres Project'        email     = 'adam@cs.caltech.edu'        homepage  = 'http://www.cs.caltech.edu/~adam/'/></bCard>");
      System.out.println(localJSONObject15.toString(2));
      System.out.println(XML.toString(localJSONObject15));
      System.out.println("");
      JSONObject localJSONObject16 = XML.toJSONObject("<?xml version=\"1.0\"?><customer>    <firstName>        <text>Fred</text>    </firstName>    <ID>fbs0001</ID>    <lastName> <text>Scerbo</text>    </lastName>    <MI>        <text>B</text>    </MI></customer>");
      System.out.println(localJSONObject16.toString(2));
      System.out.println(XML.toString(localJSONObject16));
      System.out.println("");
      JSONObject localJSONObject17 = XML.toJSONObject("<!ENTITY tp-address PUBLIC '-//ABC University::Special Collections Library//TEXT (titlepage: name and address)//EN' 'tpspcoll.sgm'><list type='simple'><head>Repository Address </head><item>Special Collections Library</item><item>ABC University</item><item>Main Library, 40 Circle Drive</item><item>Ourtown, Pennsylvania</item><item>17654 USA</item></list>");
      System.out.println(localJSONObject17.toString());
      System.out.println(XML.toString(localJSONObject17));
      System.out.println("");
      JSONObject localJSONObject18 = XML.toJSONObject("<test intertag status=ok><empty/>deluxe<blip sweet=true>&amp;&quot;toot&quot;&toot;&#x41;</blip><x>eks</x><w>bonus</w><w>bonus2</w></test>");
      System.out.println(localJSONObject18.toString(2));
      System.out.println(XML.toString(localJSONObject18));
      System.out.println("");
      JSONObject localJSONObject19 = HTTP.toJSONObject("GET / HTTP/1.0\nAccept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/vnd.ms-powerpoint, application/vnd.ms-excel, application/msword, */*\nAccept-Language: en-us\nUser-Agent: Mozilla/4.0 (compatible; MSIE 5.5; Windows 98; Win 9x 4.90; T312461; Q312461)\nHost: www.nokko.com\nConnection: keep-alive\nAccept-encoding: gzip, deflate\n");
      System.out.println(localJSONObject19.toString(2));
      System.out.println(HTTP.toString(localJSONObject19));
      System.out.println("");
      JSONObject localJSONObject20 = HTTP.toJSONObject("HTTP/1.1 200 Oki Doki\nDate: Sun, 26 May 2002 17:38:52 GMT\nServer: Apache/1.3.23 (Unix) mod_perl/1.26\nKeep-Alive: timeout=15, max=100\nConnection: Keep-Alive\nTransfer-Encoding: chunked\nContent-Type: text/html\n");
      System.out.println(localJSONObject20.toString(2));
      System.out.println(HTTP.toString(localJSONObject20));
      System.out.println("");
      JSONObject localJSONObject21 = new JSONObject("{nix: null, nux: false, null: 'null', 'Request-URI': '/', Method: 'GET', 'HTTP-Version': 'HTTP/1.0'}");
      System.out.println(localJSONObject21.toString(2));
      System.out.println("isNull: " + localJSONObject21.isNull("nix"));
      System.out.println("   has: " + localJSONObject21.has("nix"));
      System.out.println(XML.toString(localJSONObject21));
      System.out.println(HTTP.toString(localJSONObject21));
      System.out.println("");
      JSONObject localJSONObject22 = XML.toJSONObject("<?xml version='1.0' encoding='UTF-8'?>\n\n<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/1999/XMLSchema\"><SOAP-ENV:Body><ns1:doGoogleSearch xmlns:ns1=\"urn:GoogleSearch\" SOAP-ENV:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"><key xsi:type=\"xsd:string\">GOOGLEKEY</key> <q xsi:type=\"xsd:string\">'+search+'</q> <start xsi:type=\"xsd:int\">0</start> <maxResults xsi:type=\"xsd:int\">10</maxResults> <filter xsi:type=\"xsd:boolean\">true</filter> <restrict xsi:type=\"xsd:string\"></restrict> <safeSearch xsi:type=\"xsd:boolean\">false</safeSearch> <lr xsi:type=\"xsd:string\"></lr> <ie xsi:type=\"xsd:string\">latin1</ie> <oe xsi:type=\"xsd:string\">latin1</oe></ns1:doGoogleSearch></SOAP-ENV:Body></SOAP-ENV:Envelope>");
      System.out.println(localJSONObject22.toString(2));
      System.out.println(XML.toString(localJSONObject22));
      System.out.println("");
      JSONObject localJSONObject23 = new JSONObject("{Envelope: {Body: {\"ns1:doGoogleSearch\": {oe: \"latin1\", filter: true, q: \"'+search+'\", key: \"GOOGLEKEY\", maxResults: 10, \"SOAP-ENV:encodingStyle\": \"http://schemas.xmlsoap.org/soap/encoding/\", start: 0, ie: \"latin1\", safeSearch:false, \"xmlns:ns1\": \"urn:GoogleSearch\"}}}}");
      System.out.println(localJSONObject23.toString(2));
      System.out.println(XML.toString(localJSONObject23));
      System.out.println("");
      JSONObject localJSONObject24 = CookieList.toJSONObject("  f%oo = b+l=ah  ; o;n%40e = t.wo ");
      System.out.println(localJSONObject24.toString(2));
      System.out.println(CookieList.toString(localJSONObject24));
      System.out.println("");
      JSONObject localJSONObject25 = Cookie.toJSONObject("f%oo=blah; secure ;expires = April 24, 2002");
      System.out.println(localJSONObject25.toString(2));
      System.out.println(Cookie.toString(localJSONObject25));
      System.out.println("");
      JSONObject localJSONObject26 = new JSONObject("{script: 'It is not allowed in HTML to send a close script tag in a string<script>because it confuses browsers</script>so we insert a backslash before the /'}");
      System.out.println(localJSONObject26.toString());
      System.out.println("");
      JSONTokener localJSONTokener = new JSONTokener("{op:'test', to:'session', pre:1}{op:'test', to:'session', pre:2}");
      JSONObject localJSONObject27 = new JSONObject(localJSONTokener);
      System.out.println(localJSONObject27.toString());
      System.out.println("pre: " + localJSONObject27.optInt("pre"));
      int i = localJSONTokener.skipTo('{');
      System.out.println(i);
      JSONObject localJSONObject28 = new JSONObject(localJSONTokener);
      System.out.println(localJSONObject28.toString());
      System.out.println("");
      JSONArray localJSONArray8 = CDL.toJSONArray("No quotes, 'Single Quotes', \"Double Quotes\"\n1,'2',\"3\"\n,'It is \"good,\"', \"It works.\"\n\n");
      System.out.println(CDL.toString(localJSONArray8));
      System.out.println("");
      System.out.println(localJSONArray8.toString(4));
      System.out.println("");
      JSONArray localJSONArray9 = new JSONArray(" [\"<escape>\", next is an implied null , , ok,] ");
      System.out.println(localJSONArray9.toString());
      System.out.println("");
      System.out.println(XML.toString(localJSONArray9));
      System.out.println("");
      JSONObject localJSONObject29 = new JSONObject("{ fun => with non-standard forms ; forgiving => This package can be used to parse formats that are similar to but not stricting conforming to JSON; why=To make it easier to migrate existing data to JSON,one = [[1.00]]; uno=[[{1=>1}]];'+':+6e66 ;pluses=+++;empty = '' , 'double':0.666,true: TRUE, false: FALSE, null=NULL;[true] = [[!,@;*]]; string=>  o. k. ; \r oct=0666; hex=0x666; dec=666; o=0999; noh=0x0x}");
      System.out.println(localJSONObject29.toString(4));
      System.out.println("");
      if ((localJSONObject29.getBoolean("true")) && (!localJSONObject29.getBoolean("false"))) {
        System.out.println("It's all good");
      }
      System.out.println("");
      JSONObject localJSONObject30 = new JSONObject(localJSONObject29, new String[] { "dec", "oct", "hex", "missing" });
      System.out.println(localJSONObject30.toString(4));
      System.out.println("");
      System.out.println(new JSONStringer().array().value(localJSONArray9).value(localJSONObject30).endArray());
      JSONObject localJSONObject31 = new JSONObject("{string: \"98.6\", long: 2147483648, int: 2147483647, longer: 9223372036854775807, double: 9223372036854775808}");
      System.out.println(localJSONObject31.toString(4));
      System.out.println("\ngetInt");
      System.out.println("int    " + localJSONObject31.getInt("int"));
      System.out.println("long   " + localJSONObject31.getInt("long"));
      System.out.println("longer " + localJSONObject31.getInt("longer"));
      System.out.println("double " + localJSONObject31.getInt("double"));
      System.out.println("string " + localJSONObject31.getInt("string"));
      System.out.println("\ngetLong");
      System.out.println("int    " + localJSONObject31.getLong("int"));
      System.out.println("long   " + localJSONObject31.getLong("long"));
      System.out.println("longer " + localJSONObject31.getLong("longer"));
      System.out.println("double " + localJSONObject31.getLong("double"));
      System.out.println("string " + localJSONObject31.getLong("string"));
      System.out.println("\ngetDouble");
      System.out.println("int    " + localJSONObject31.getDouble("int"));
      System.out.println("long   " + localJSONObject31.getDouble("long"));
      System.out.println("longer " + localJSONObject31.getDouble("longer"));
      System.out.println("double " + localJSONObject31.getDouble("double"));
      System.out.println("string " + localJSONObject31.getDouble("string"));
      localJSONObject31.put("good sized", Long.MAX_VALUE);
      System.out.println(localJSONObject31.toString(4));
      JSONArray localJSONArray10 = new JSONArray("[2147483647, 2147483648, 9223372036854775807, 9223372036854775808]");
      System.out.println(localJSONArray10.toString(4));
      System.out.println("\nKeys: ");
      Iterator localIterator = localJSONObject31.keys();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        System.out.println(str2 + ": " + localJSONObject31.getString(str2));
      }
      System.out.println("\naccumulate: ");
    }
    catch (Exception localException1)
    {
      System.out.println(localException1.toString());
      return;
    }
    JSONObject localJSONObject32 = new JSONObject();
    localJSONObject32.accumulate("stooge", "Curly");
    localJSONObject32.accumulate("stooge", "Larry");
    localJSONObject32.accumulate("stooge", "Moe");
    localJSONObject32.getJSONArray("stooge").put(5, "Shemp");
    System.out.println(localJSONObject32.toString(4));
    System.out.println("\nwrite:");
    System.out.println(localJSONObject32.write(new StringWriter()));
    JSONObject localJSONObject33 = XML.toJSONObject("<xml empty><a></a><a>1</a><a>22</a><a>333</a></xml>");
    System.out.println(localJSONObject33.toString(4));
    System.out.println(XML.toString(localJSONObject33));
    JSONObject localJSONObject34 = XML.toJSONObject("<book><chapter>Content of the first chapter</chapter><chapter>Content of the second chapter      <chapter>Content of the first subchapter</chapter>      <chapter>Content of the second subchapter</chapter></chapter><chapter>Third Chapter</chapter></book>");
    System.out.println(localJSONObject34.toString(4));
    System.out.println(XML.toString(localJSONObject34));
    JSONArray localJSONArray11 = JSONML.toJSONArray("<book><chapter>Content of the first chapter</chapter><chapter>Content of the second chapter      <chapter>Content of the first subchapter</chapter>      <chapter>Content of the second subchapter</chapter></chapter><chapter>Third Chapter</chapter></book>");
    System.out.println(localJSONArray11.toString(4));
    System.out.println(JSONML.toString(localJSONArray11));
    JSONObject localJSONObject35 = new JSONObject(null);
    JSONArray localJSONArray12 = new JSONArray(null);
    localJSONObject35.append("stooge", "Joe DeRita");
    localJSONObject35.append("stooge", "Shemp");
    localJSONObject35.accumulate("stooges", "Curly");
    localJSONObject35.accumulate("stooges", "Larry");
    localJSONObject35.accumulate("stooges", "Moe");
    localJSONObject35.accumulate("stoogearray", localJSONObject35.get("stooges"));
    localJSONObject35.put("map", null);
    localJSONObject35.put("collection", null);
    localJSONObject35.put("array", localJSONArray12);
    localJSONArray12.put(null);
    localJSONArray12.put(null);
    System.out.println(localJSONObject35.toString(4));
    JSONObject localJSONObject36 = new JSONObject("{plist=Apple; AnimalSmells = { pig = piggish; lamb = lambish; worm = wormy; }; AnimalSounds = { pig = oink; lamb = baa; worm = baa;  Lisa = \"Why is the worm talking like a lamb?\" } ; AnimalColors = { pig = pink; lamb = black; worm = pink; } } ");
    System.out.println(localJSONObject36.toString(4));
    localJSONArray13 = new JSONArray(" (\"San Francisco\", \"New York\", \"Seoul\", \"London\", \"Seattle\", \"Shanghai\")");
    System.out.println(localJSONArray13.toString());
    JSONObject localJSONObject37 = XML.toJSONObject("<a ichi='1' ni='2'><b>The content of b</b> and <c san='3'>The content of c</c><d>do</d><e></e><d>re</d><f/><d>mi</d></a>");
    System.out.println(localJSONObject37.toString(2));
    System.out.println(XML.toString(localJSONObject37));
    System.out.println("");
    JSONArray localJSONArray14 = JSONML.toJSONArray("<a ichi='1' ni='2'><b>The content of b</b> and <c san='3'>The content of c</c><d>do</d><e></e><d>re</d><f/><d>mi</d></a>");
    System.out.println(localJSONArray14.toString(4));
    System.out.println(JSONML.toString(localJSONArray14));
    System.out.println("");
    System.out.println("\nTesting Exceptions: ");
    System.out.print("Exception: ");
    for (;;)
    {
      try
      {
        localJSONArray15 = new JSONArray();
      }
      catch (Exception localException3)
      {
        JSONObject localJSONObject40;
        JSONObject localJSONObject39;
        JSONObject localJSONObject38;
        JSONArray localJSONArray16;
        JSONArray localJSONArray17;
        JSONArray localJSONArray19;
        JSONArray localJSONArray18;
        JSONArray localJSONArray15 = localJSONArray13;
        continue;
      }
      try
      {
        localJSONArray15.put(Double.NEGATIVE_INFINITY);
        localJSONArray15.put(NaN.0D);
        System.out.println(localJSONArray15.toString());
        System.out.print("Exception: ");
      }
      catch (Exception localException2)
      {
        continue;
      }
      try
      {
        System.out.println(localJSONObject37.getDouble("stooge"));
        System.out.print("Exception: ");
      }
      catch (Exception localException15)
      {
        try
        {
          System.out.println(localJSONObject37.getDouble("howard"));
          System.out.print("Exception: ");
        }
        catch (Exception localException15)
        {
          try
          {
            System.out.println(localJSONObject37.put(null, "howard"));
            System.out.print("Exception: ");
          }
          catch (Exception localException15)
          {
            try
            {
              System.out.println(localJSONArray15.getDouble(0));
              System.out.print("Exception: ");
            }
            catch (Exception localException15)
            {
              try
              {
                System.out.println(localJSONArray15.get(-1));
                System.out.print("Exception: ");
              }
              catch (Exception localException15)
              {
                try
                {
                  System.out.println(localJSONArray15.put(NaN.0D));
                  System.out.print("Exception: ");
                }
                catch (Exception localException15)
                {
                  try
                  {
                    localJSONObject40 = XML.toJSONObject("<a><b>    ");
                    localObject2 = localJSONObject40;
                    System.out.print("Exception: ");
                  }
                  catch (Exception localException15)
                  {
                    try
                    {
                      localJSONObject39 = XML.toJSONObject("<a></b>    ");
                      localObject2 = localJSONObject39;
                      System.out.print("Exception: ");
                    }
                    catch (Exception localException15)
                    {
                      try
                      {
                        localJSONObject38 = XML.toJSONObject("<a></a    ");
                        localObject2 = localJSONObject38;
                        System.out.print("Exception: ");
                      }
                      catch (Exception localException15)
                      {
                        try
                        {
                          localJSONArray16 = new JSONArray(new Object());
                          System.out.println(localJSONArray16.toString());
                          System.out.print("Exception: ");
                        }
                        catch (Exception localException15)
                        {
                          try
                          {
                            localJSONArray17 = new JSONArray("[)");
                            System.out.println(localJSONArray17.toString());
                            System.out.print("Exception: ");
                          }
                          catch (Exception localException15)
                          {
                            try
                            {
                              localJSONArray19 = JSONML.toJSONArray("<xml");
                              System.out.println(localJSONArray19.toString(4));
                              System.out.print("Exception: ");
                            }
                            catch (Exception localException15)
                            {
                              try
                              {
                                localJSONArray18 = JSONML.toJSONArray("<right></wrong>");
                                System.out.println(localJSONArray18.toString(4));
                                System.out.print("Exception: ");
                                try
                                {
                                  localObject3 = new JSONObject("{\"koda\": true, \"koda\": true}");
                                }
                                catch (Exception localException18)
                                {
                                  Object localObject1;
                                  Object localObject4;
                                  Object localObject3 = localObject2;
                                  continue;
                                }
                                try
                                {
                                  System.out.println(((JSONObject)localObject3).toString(4));
                                  System.out.print("Exception: ");
                                  try
                                  {
                                    new JSONStringer().object().key("bosanda").value("MARIE HAA'S").key("bosanda").value("MARIE HAA\\'S").endObject().toString();
                                    System.out.println(((JSONObject)localObject3).toString(4));
                                    return;
                                  }
                                  catch (Exception localException19)
                                  {
                                    System.out.println(localException19);
                                    return;
                                  }
                                  System.out.println(localObject1);
                                }
                                catch (Exception localException17)
                                {
                                  continue;
                                }
                                localException4 = localException4;
                                System.out.println(localException4);
                                continue;
                                localException5 = localException5;
                                System.out.println(localException5);
                                continue;
                                localException6 = localException6;
                                System.out.println(localException6);
                                continue;
                                localException7 = localException7;
                                System.out.println(localException7);
                                continue;
                                localException8 = localException8;
                                System.out.println(localException8);
                                continue;
                                localException9 = localException9;
                                System.out.println(localException9);
                                continue;
                                localException10 = localException10;
                                System.out.println(localException10);
                                localObject2 = localJSONObject37;
                                continue;
                                localException11 = localException11;
                                System.out.println(localException11);
                                continue;
                                localException12 = localException12;
                                System.out.println(localException12);
                                continue;
                                localException13 = localException13;
                                System.out.println(localException13);
                                continue;
                                localException14 = localException14;
                                System.out.println(localException14);
                                continue;
                                localException15 = localException15;
                                System.out.println(localException15);
                              }
                              catch (Exception localException16)
                              {
                                System.out.println(localException16);
                                continue;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      System.out.println(localObject4);
    }
  }
}
