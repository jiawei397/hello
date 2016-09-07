package hello;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try{   
            // 连接到 mongodb 服务
              MongoClient mongoClient = new MongoClient( "127.0.0.1" , 27017 );
//              MongoClient mongoClient = new MongoClient( "192.168.10.64" , 27017 );
            
              // 连接到数据库
              MongoDatabase mongoDatabase = mongoClient.getDatabase("runoob");  
            System.out.println("Connect to database " + mongoDatabase.getName() +" successfully");
            
//            mongoDatabase.createCollection("test");
//            System.out.println("集合创建成功");
            
            MongoCollection collection = mongoDatabase.getCollection("col");
            System.out.println("集合 col 选择成功");
            
            //插入文档  
            /** 
            * 1. 创建文档 org.bson.Document 参数为key-value的格式 
            * 2. 创建文档集合List<Document> 
            * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document) 
            * */
//            Document document = new Document("title", "MongoDB").  
//            append("description", "database").  
//            append("likes", 100).  
//            append("by", "Fly");  
//            List<Document> documents = new ArrayList<Document>();  
//            documents.add(document);  
//            collection.insertMany(documents);  
//            System.out.println("文档插入成功");  
             
          //更新文档   将文档中likes=100的文档修改为likes=200   
//            collection.updateMany(Filters.eq("likes", 100), new Document("$set",new Document("likes",200)));  
            
            //删除符合条件的第一个文档  
//            collection.deleteOne(Filters.eq("likes", 200));  
            //删除所有符合条件的文档  
//            collection.deleteMany (Filters.eq("likes", 200));  
            
            /** 
             * 1. 获取迭代器FindIterable<Document> 
             * 2. 获取游标MongoCursor<Document> 
             * 3. 通过游标遍历检索出的文档集合 
             * */  
             FindIterable findIterable = collection.find();  
             MongoCursor mongoCursor = findIterable.iterator();  
             while(mongoCursor.hasNext()){  
                System.out.println(mongoCursor.next());  
             }  
           }catch(Exception e){
             System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          }
    }
}
