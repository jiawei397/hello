package mongo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.bson.codecs.configuration.CodecRegistry;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoCredential;
import com.mongodb.MongoOptions;
import com.mongodb.ReplicaSetStatus;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class MongoUtil {

	 private static MongoClientOptions db;

	/** 
     * 有用户名密码的方式连接mongoDB（MongoCredential方式） 
     * @param mongodbAddr 
     * @param databaseName 
     * @return 
     */  
    public static MongoClient getMongoClientByCredent(){  
    	ResourceBundle rb = ResourceBundle.getBundle("config", Locale.getDefault());
        String user = rb.getString("userName");
        String pswd = rb.getString("password");
        String host = rb.getString("host");
        Integer port = Integer.parseInt(rb.getString("port"));
        String databaseName = rb.getString("databaseName");
        List<ServerAddress> serverAddrList = new ArrayList<ServerAddress>();  
        ServerAddress serverAddress = new ServerAddress(host,port);  
        serverAddrList.add(serverAddress);  
        List<MongoCredential> credentialList = new ArrayList<MongoCredential>();  
        MongoCredential credential = MongoCredential.createCredential(user, databaseName, pswd.toCharArray());  
        credentialList.add(credential);  
        MongoClient mongoClient = new MongoClient(serverAddrList, credentialList);  
        return mongoClient;  
    }  
      
    /** 
     * 有用户名密码的方式连接mongoDB（URI方式） 
     * @param mongodbAddr 
     * @param databaseName 
     * @return 
     */  
    @SuppressWarnings("deprecation")
	public static MongoClient getMongoClientByURI(){  
    	ResourceBundle rb = ResourceBundle.getBundle("config", Locale.getDefault());
        String user = rb.getString("userName");
        String pswd = rb.getString("password");
        String host = rb.getString("host");
        Integer port = Integer.parseInt(rb.getString("port"));
        String databaseName = rb.getString("databaseName");
      //mongodb://fred:foobar@localhost:27018/admin
        String uri = String.format("mongodb://%s:%s@%s:%s/%s", user, pswd, host,port,databaseName);  
        System.out.println(uri);  
        MongoClient mongoClient = null;
    	MongoClientURI mongoClientURI = new MongoClientURI(uri);  
        mongoClient = new MongoClient(mongoClientURI);  
		return mongoClient;  
    }  
}
