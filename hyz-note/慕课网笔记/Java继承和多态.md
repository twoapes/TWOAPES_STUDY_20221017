# Java继承和多态

## **什么是多态**

>**● 程序运行过程中,对象角色的切换**
>**● 程序运行过程中,对象行为的扩展**

### **继承基本语法和使用场景**

>**多态基础:继承**
>**继承:面向对象特性**
>**● 继承基本语法结构**
>**● 继承关系的应用:医疗项目-实体类父类**

```java
/**
* 子类:当前类型
*/
public class Son extends Father {
    public void playGame() {
        System.out.println(this.getName() + "在游戏中....");
    }
    public static void main(String[] args) {
        Son son = new Son();
        //操作属性
        son.setName("李白");
        //操作方法
        son.working();
        son.playGame();
    }
}
public class Father {
    private Integer regNo;
    private String name;
    private String gender;
    private String age;
    private String jon;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Integer getRegNo() {
        return regNo;
    }
    public void setRegNo(Integer regNo) {
        this.regNo = regNo;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getJon() {
        return jon;
    }
    public void setJon(String jon) {
        this.jon = jon;
    }
    public void working() {
        System.out.println(this.name + "在工作中....");
    }
}
```

![1689144929603](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/1689144929603.png)
![1689144960758](https://twoapes.oss-cn-shenzhen.aliyuncs.com/image/1689144960758.png)

```java
public class SystemUser {
    private System username;//账号
    private System password;//密码
    private System name;//姓名
    private System sex;//性别
    private int age;//年龄
    private String regNo;//身份证号码
    private String phone;//手机号
    private String email;//邮箱
    private String address;//地址
    //如果不显示出来,那么子类无法使用被隐藏的无参构造方法
    public SystemUser() {
    }
    public SystemUser(System username, System password, System name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
    public System getUsername() {
        return username;
    }
    public void setUsername(System username) {
        this.username = username;
    }
    public System getPassword() {
        return password;
    }
    public void setPassword(System password) {
        this.password = password;
    }
    public System getName() {
        return name;
    }
    public void setName(System name) {
        this.name = name;
    }
    public System getSex() {
        return sex;
    }
    public void setSex(System sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getRegNo() {
        return regNo;
    }
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
/**
* 系统管理员
*/
public class Manager extends SystemUser {
}
/**
* 医师
*/
public class Doctor extends SystemUser{
    private System department;//部门
    private System offices;//科室
}
/**
* 医护人员
*/
public class Nurse extends SystemUser {
    private System department;//部门
}
```

## **final和super关键字**

### **fianl关键字**

>**继承:基于类型的控制**
>**final关键字:最终的类型**
>**继承关系的限制:医疗项目-物品清单**
>**不能被继承,也不能实现接口**

```java
/**
* 医疗项目中的采购清单
* 采购方/联系方式/邮箱/传真/地址
* 提供方/联系方式/邮箱/传真/地址
* 采购单编号/采购类型/采购规格/采购单价/采购时间/注意事项 1~n
*/
public final class Purchase {
    private String demandName;//采购方
    private String demandPhone;//联系方式
    private String demandEmail;//邮箱
    private String demandFax;//传真
    private String demandAddress;//地址
    private String supplyName;//提供方
    private String supplyPhone;//联系方式
    private String supplyEmail;//邮箱
    private String supplyFax;//传真
    private String supplyAddress;//地址
    private Integer purchaseId;//采购单编号
    private String purchaseType;//采购类型
    private String purchaseBrand;//采购规格
    private String purchasePrice;//采购单价
    private String purchaseDeal;//采购时间
    private String purchaseRemark;//注意事项
    private String purchaseRemark1;//注意事项
    private String purchaseRemark2;//注意事项
    private String purchaseRemark3;//注意事项
    private String purchaseRemark4;//注意事项
    public String getDemandName() {
        return demandName;
    }
    public String getDemandPhone() {
        return demandPhone;
    }
    public String getDemandEmail() {
        return demandEmail;
    }
    public String getDemandFax() {
        return demandFax;
    }
    public String getDemandAddress() {
        return demandAddress;
    }
    public String getSupplyName() {
        return supplyName;
    }
    public String getSupplyPhone() {
        return supplyPhone;
    }
    public String getSupplyEmail() {
        return supplyEmail;
    }
    public String getSupplyFax() {
        return supplyFax;
    }
    public String getSupplyAddress() {
        return supplyAddress;
    }
    public Integer getPurchaseId() {
        return purchaseId;
    }
    public String getPurchaseType() {
        return purchaseType;
    }
    public String getPurchaseBrand() {
        return purchaseBrand;
    }
    public String getPurchasePrice() {
        return purchasePrice;
    }
    public String getPurchaseDeal() {
        return purchaseDeal;
    }
    public String getPurchaseRemark() {
        return purchaseRemark;
    }
    public String getPurchaseRemark1() {
        return purchaseRemark1;
    }
    public String getPurchaseRemark2() {
        return purchaseRemark2;
    }
    public String getPurchaseRemark3() {
        return purchaseRemark3;
    }
    public String getPurchaseRemark4() {
        return purchaseRemark4;
    }
}
```

### **super关键字**

>**继承:单继承,突破访问限制**
>**● Java中单继承的优势**
>**● supper关键字,让父类的方法飞起来**

```java
public class Users {
    private int id;
    private String name;
    private int age;
    private String gender;
    public boolean equals(Object obj) {
        if (!(obj instanceof Users)) {
            return false;
        }
        Users users = (Users) obj;
        return this.age >= users.age;
    }
}
/**
* 医师类型
*/
public class Doctor extends Users {
    private String job;
    private int level;
    public boolean equals(Object obj) {
        if (!(obj instanceof Doctor)) {
            return false;
        }
        Doctor doctor = (Doctor) obj;
        if (this.level > doctor.level) {
            return true;
        } else if (this.level < doctor.level) {
            return false;
        } else {
            return super.equals(obj);
        }
    }
}
```

## **方法重载和方法重写**

>**继承:方法重载和重写**
>**● 方法重载:设计时多态,医疗项目科室领取设备记录**
>**● 方法重写:运行时多态,医疗项目业务受理接口开发**
>**设计多态**

```java
/**
 * 设备服务类型
 */
public class DeviceService {
    private String getDevice() {
        return "医师领取的设备";
    }
    /**
     * 医护领取设备
     *
     * @param notes 领取记录
     * @return 返回领取到的记录
     */
    private String getDevice(String notes) {
        return "医护领取的设备";
    }
    /**
     * 病人领取设备
     *
     * @param offices 治疗科室
     * @param notes   领取记录
     * @return 返回领取到的记录
     */
    private String getDevice(String offices, String notes) {
        return "病人领取的设备";
    }
    public static void main(String[] args) {
        DeviceService deviceService = new DeviceService();
        String res = deviceService.getDevice();
        System.out.println(res);
        String res2 = deviceService.getDevice("手术用品");
        System.out.println(res2);
        String res3 = deviceService.getDevice("骨科", "固定带");
        System.out.println(res3);
    }
}
```

>**运行时多态**

```java
/**
* 医院类型
*/
public class Hospital {
    public void register(Patient patient, Department department) {
        System.out.println("开始挂号到对应的科室" + department.getName());
        department.treatment(patient);
    }
    public static void main(String[] args) {
        //医院
        Hospital hospital = new Hospital();
        //骨科
        Orthopaedics orthopaedics = new Orthopaedics();
        orthopaedics.setName("骨科");
        //外科
        Surgery surgery = new Surgery();
        surgery.setName("外科");
        //病人
        Patient patient=new Patient();
        hospital.register(patient,surgery);
        System.out.println("----------------------------");
        hospital.register(patient,orthopaedics);
    }
}
class Patient {
    private int id;//编号
    private String name;//姓名
    private String gender;//性别
    private int age;//性别
    private float health;//健康状态
}
class Department {
    private int id;//编号
    private String name;//姓名
    private String intro;//介绍
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void treatment(Patient patient) {
        System.out.println(this.name + "接受病人,开始治疗");
    }
}
class Orthopaedics extends Department {
    @Override
    public void treatment(Patient patient) {
        System.out.println(this.getName() + "骨科接受到病人,开始给病人进行治疗...");
    }
}
class Surgery extends Department {
    @Override
    public void treatment(Patient patient) {
        System.out.println(this.getName() + "外科接受到病人,准备给病人手术...");
    }
}
```

>**如果需要方法参数不同,那么使用设计时多态**
>**如果需要方法参数相同,那么使用运行时多态**

## **接口和抽象类**

### **抽象类和抽象方法**

>**抽象:抽象类基本概念**
>**基本语法:抽象类的意义及实现**
>**抽象方法:抽象类中的逻辑体现**

```java
public class InheritSytax {
    /**
     * 驱动器类型
     */
    static abstract class Device {
        //方法使用abstract声明:抽象方法,子类继承父类时必须重写的方法
        public abstract void working();
        //展示硬盘信息
        public void showInformation() {
            System.out.println("这是一个机械硬盘...");
        }
    }
    static class DeviceSystem extends Device {
        @Override
        public void working() {
            System.out.println("系统盘正在工作中...");
        }
    }
    static class DeviceBackUp extends Device {
        @Override
        public void working() {
            System.out.println("备份盘正在工作中...");
        }
    }
    public static void main(String[] args) {
        //父类实例化测试:抽象类型不能被实例化
        //Device device=new Device();
        //子类实例化
        DeviceSystem deviceSystem = new DeviceSystem();
        deviceSystem.working();
        DeviceBackUp deviceBackUp=new DeviceBackUp();
        deviceBackUp.working();
    }
}
```

### **抽象类银行存款**

>**继承:抽象类应用操作**

```java
/**
* 银行类型
*/
public class Bank {
    /**
     * 业务类
     */
    static abstract class Service {
        /**
         *
         */
        public abstract String deposit(double money);
    }
    static class CashDesk extends Service {
        @Override
        public String deposit(double money) {
            System.out.println("柜台存款,存款:" + money);
            return "柜台存款";
        }
    }
    static class ATM extends Service {
        @Override
        public String deposit(double money) {
            System.out.println("ATM存款,存款:" + money);
            return "ATM存款";
        }
    }
    public static void main(String[] args) {
        Service service = new Bank.CashDesk();//柜台对象
        Service service2 = new Bank.ATM();//AMT机
        //存款入口
        service.deposit(100);
        service2.deposit(200);
    }
}
```

### **接口基本语法操作**

```java
/**
 * 接口声明使用 interface 关键字,后缀依然是.java,编译后还是.class文件
 * 通常会使用I开头,标明这就是一个接口
 * 属性默认:public static final
 * 方法默认:public abstract
 * jdk1.7版本接口只允许存在抽象方法
 * 接口的实现方式:
 *     一个接口一个继承来一个接口[单继承机制]
 *     一个类型(可实例化)可以实现多个接口[多实例机制]
 *jdk8以后的版本:
 *      静态方法 不能被实现类继承,不能被子接口继承
 *      提供给所有的实现类使用的一种公共方法,访问公共数据
 *      接口中的静态方法只能被接口名称调用
 *
 *jdk8以后的版本:
 *      默认方法
 *      提供给所有的实现类的一种特殊的方法,提供了一种默认的处理方式
 *      用于独立的基础功能的实现
 *      默认方法可以被子接口继承,可以被实现类继承和重写
 *
 * 如果一个类型实现了多个接口
 * 多个接口中出现了同名的默认方法,此时就出现了接口冲突的问题
 * 实现类中,必须重写默认方法,解决冲突!
 */
public interface IDataType {
    //属性
    String TYPE = "JSON";
    public static final String TYPE2 = "JSON";
    //方法
    String format_msg(String msg);
    public abstract String format_msg2(String msg);
    static String getType(){
        return IDataType.TYPE;
    }
    default String transfer_msg(String msg){
        String res=this.format_msg(msg);
        System.out.println("数据开始传输");
        return "数据传输结果";
    }
    public static void main(String[] args) {
        String res=IDataType.getType();//静态方法
        System.out.println(res);
        JsonData jsonData=new JsonData();
        jsonData.transfer_msg("hello tom!");//调用默认方法
        String res2=jsonData.format_msg("hello jerry!");//调用普通方法
        System.out.println(res2);
    }
}
class JsonData implements IDataType{
    public String format_msg(String msg) {
        return "json 类型的 序列化操作";
    }
    public String format_msg2(String msg) {
        return null;
    }
}
```

### **接口的应用**

>**接口:接口即规范**
>**访问规范:数据采集接口,服务数据的规范**
>**标记接口:数据特征的定位**

```java
/**
 * 接口标记 测试代码
 */
public class DataApp {
    /**
     * 接口标记:一旦一个类型被当前接口标记
     * <p>
     * 这个类型在进行数据传输时,就需要进行特殊的处理
     */
    static interface IDataFormat {
    }
    /**
     * 数据传输的方法
     */
    public String transfer(Object o) {
        if (o instanceof IDataFormat) {
            System.out.println("复杂数据,需要进行序列化处理和类型转换");
        }
        System.out.println("数据监测完成,数据开始传输...");
        System.out.println("数据传输完成");
        return "ok";
    }
    static class Address {
        private int id;//编号
        private String nation;//国家
        private String province;//省份
        private String city;//省份
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getNation() {
            return nation;
        }
        public void setNation(String nation) {
            this.nation = nation;
        }
        public String getProvince() {
            return province;
        }
        public void setProvince(String province) {
            this.province = province;
        }
        public String getCity() {
            return city;
        }
        public void setCity(String city) {
            this.city = city;
        }
    }
    static class Person implements IDataFormat {
        private int id;//编号
        private String name;//姓名
        private String gender;//性别
        private int age;//年龄
        private Address address;//地址
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getGender() {
            return gender;
        }
        public void setGender(String gender) {
            this.gender = gender;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public Address getAddress() {
            return address;
        }
        public void setAddress(Address address) {
            this.address = address;
        }
    }
    public static void main(String[] args) {
        //数据传输
        DataApp dataApp = new DataApp();
        //准备数据
        Address address = new Address();
        Person person = new Person();
        //数据传输
        dataApp.transfer("hello");
        System.out.println("------------------");
        dataApp.transfer(12);
        System.out.println("------------------");
        dataApp.transfer(address);
        System.out.println("------------------");
        dataApp.transfer(person);
    }
}
```

## **多态**

### **多态概述**

>**● 对象行为的转换,方法重写实现的操作**
>**● 对象角色的转换,接口多实现的操作**

### **多态操作实例**

>**● 商城秒杀系统:设计时多态的实现**
>**● 商城秒杀系统:运行时多态的实现**

```java
/**
 * 商城秒杀
 * <p>
 * 设计时多态
 */

public class Shopping {

    /**
     * 秒杀方法
     *
     * @param name       秒杀商品
     * @param deviceType 终端类型
     * @param deviceInfo 终端信息
     */

    public void secKill(String name, int deviceType, String deviceInfo) {
        System.out.println("正在秒杀商品:" + name);
        if (deviceType == 1) {
            this.record(name, Integer.parseInt(deviceInfo));
        } else if (deviceType == 2) {

            this.record(name, deviceInfo);
        }
    }



    /**
     * 记录移动端秒杀信息的方法
     *
     * @param name  秒杀的商品
     * @param phone 手机号码
     */

    public void record(String name, long phone) {
        System.out.println("记录--秒杀商品:" + name + "; 移动终端信息:" + phone);
    }



    /**
     * 记录PC端秒杀信息的方法
     *
     * @param name 秒杀的商品
     * @param url  PC端地址[IP]
     */

    public void record(String name, String url) {
        System.out.println("记录--秒杀商品:" + name + "; PC终端信息:" + url);
    }



    public static void main(String[] args) {
        Shopping shopping = new Shopping();
        shopping.secKill("aLiEnWare", 1, "156888999");
        shopping.secKill("asua", 2, "10.10.68.92");
    }
}
```

```java
/**
 * Shopping2
 * 运行时多态
 */
public class Shopping2 {
    /**
     * 秒杀方法
     *
     * @param name   秒杀商品
     * @param device 终端设备信息
     */
    public void secKill(String name, Device device) {
        System.out.println("正在秒杀商品:" + name);
        System.out.println("记录秒杀信息");
        device.record(name);
    }
    public static void main(String[] args) {
        Shopping2 shopping2 = new Shopping2();
        //PC
        Device pc = new PC();
        shopping2.secKill("玩家国度", pc);
        System.out.println("------------------------");
        //移动端
        Device phone = new Phone();
        shopping2.secKill("飞行堡垒", phone);
    }
}
abstract class Device {
    public abstract void record(String name);
}
class Phone extends Device {
    public void record(String name) {
        System.out.println("移动终端机发起的秒杀,商品名称:" + name);
    }
}
class PC extends Device {
    public void record(String name) {
        System.out.println("PC端发起的秒杀,商品名称:" + name);
    }
}
```

>**如果需要方法参数不同,那么使用设计时多态**
>**如果需要方法参数相同,那么使用运行时多态**

## **课程总结**

>**继承**
>**● 继承的意义**
>**● 继承的适用场景**
>
>**多态**
>**● 多态的意义**
>**● 多态的适用场景**
>**java面向对象**
>**● 三大特性:封装,继承,多态**
>**● 关于继承和多态**
