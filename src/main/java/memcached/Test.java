package memcached;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

public class Test {
	
	public void test(){
		System.err.println("这是测试方法");
	}
	
	public static void main(String[] args) {
		 try{
	         // 本地连接 Memcached 服务
	         MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
	         System.out.println("Connection to server sucessful.");
	         
	         // 存储数据
//	         Future fo = mcc.set("runoob", 900, "Free Education");
//	      
//	         // 查看存储状态
//	         System.out.println("set status:" + fo.get());
//	         

	         
	      // 添加
//	         Future fo = mcc.add("runoob", 900, "memcached");

	         // 打印状态
//	         System.out.println("add status:" + fo.get());
//	         // 输出值
//	         System.out.println("runoob value in cache - " + mcc.get("runoob"));
//	         
//	         // 添加新的 key
//	         fo = mcc.replace("runoob", 900, "Largest Tutorials' Library");
//
//	         // 输出执行 set 方法后的状态
//	         System.out.println("replace status:" + fo.get());
//
//	         // 获取键对应的值
//	         System.out.println("runoob value in cache - " + mcc.get("runoob"));
	         

	         // 添加新key
//	         fo = mcc.add("codingground", 900, "All Free Compilers");
//
//	         // 打印状态
//	         System.out.println("add status:" + fo.get());
//	         
//	         // 输出
//	         System.out.println("codingground value in cache - " + mcc.get("codingground"));
	         
	         
	         // 对存在的key进行数据添加操作
//	         fo = mcc.append("runoob", " for All");
	         
	      // 对存在的key进行数据添加操作
//	         fo = mcc.prepend("runoob", "haha ");
//
//	         // 输出执行 set 方法后的状态
//	         System.out.println("append status:" + fo.get());
//	         
//	         // 获取键对应的值
//	         System.out.println("runoob value in cache - " + mcc.get("runoob"));

	         
//	         // 通过 gets 方法获取 CAS token（令牌）
//	         CASValue casValue = mcc.gets("runoob");
//
//	         // 输出 CAS token（令牌） 值
//	         System.out.println("CAS token - " + casValue);
//
//	         // 尝试使用cas方法来更新数据
//	         CASResponse casresp = mcc.cas("runoob", casValue.getCas(), 900, "Largest Tutorials-Library");
//	         
//	         // 输出 CAS 响应信息
//	         System.out.println("CAS Response - " + casresp);
//
//	         // 输出值
//	         System.out.println("runoob value in cache - " + mcc.get("runoob"));

	         
	      // 对存在的key进行数据添加操作
//	         Future fo = mcc.delete("runoob");
//
//	         // 输出执行 delete 方法后的状态
//	         System.out.println("delete status:" + fo.get());
//	         
//	         // 输出值
//	         System.out.println("runoob value in cache - " + mcc.get("runoob"));
	         
	         
	         // 添加数字值
	         Future fo = mcc.set("number", 900, "1000");

	         // 输出执行 set 方法后的状态
	         System.out.println("set status:" + fo.get());

	         // 获取键对应的值
	         System.out.println("value in cache - " + mcc.get("number"));

	         // 自增并输出
	         System.out.println("value in cache after increment - " + mcc.incr("number", 111));

	         // 自减并输出
	         System.out.println("value in cache after decrement - " + mcc.decr("number", 112));
	         
	         
	         // 关闭连接
	         mcc.shutdown();
	         
	      }catch(Exception ex){
	         System.out.println( ex.getMessage() );
	      }
	}
}
