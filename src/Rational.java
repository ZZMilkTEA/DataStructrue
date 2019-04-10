//一个有理数的数据结构类型
public class Rational {
    private int num;    //分子
    private int den;    //分母

    public Rational() {     //无参构造函数
        this.num = 1;
        this.den = 1;
    }

    public Rational(int num, int den) { //输入分子分母时的构造函数
        if(den == 0){
            throw new IllegalArgumentException("分母不能为0");
        }
        this.num = num;
        this.den = den;
        this.reduFrac();
    }

    public Rational(double number,double delta) { //输入实数和误差范围时的构造函数
        int num =1,den = 1;     //从1/1开始判断
        int number_int = 0; //判断前默认整数部分为0
        double number_dec;
        if(number > 1){     //如果输入的实数大于0，则分离整数部分和小数部分
            number_int = (int)number/1;
            number_dec = number - number_int;
        }else {
            number_dec = number;
        }
        while (true) {
            //如果目前查找的函数在输入实数的误差范围内，则输出该分数（补充整数部分）
            if ((double) num / den >= number_dec - delta && (double) num / den <= number_dec + delta) {
                this.num = num+den*number_int;
                this.num = num+den*number_int;
                this.den = den;
                break;  //找到则跳出循环
            }
            else {
                num++;  //不是则分子+1。若形成假分数，则分子置1，分母+1
                if (num >= den) {
                    num = 1;
                    den++;
                }
            }
        }
    }

    private static int gcd(int a,int b){    //求最大公因数
        for(int i = Math.min(a,b); i > 0; i--) {
            if (Math.min(a, b) % i == 0) {
                if (Math.max(a, b) % i == 0) {
                    return i;
                }
            }
        }
        return 1;
    }

    private void reduFrac(){    //对一个有理数进行约分,一般在每次赋值和运算后执行一次
        int maxComFact = gcd(this.num,this.den);
        this.num /= maxComFact;
        this.den /= maxComFact;
    }

    public static Rational plus(Rational a,Rational b){    //加法运算
        Rational result = new Rational();
        result.num = a.num * b.den + a.den * b.num;
        result.den = a.den * b.den;
        result.reduFrac();
        return result;
    }

    public static Rational minus(Rational a,Rational b){   //减法运算
        Rational result = new Rational();
        result.num = a.num * b.den - a.den * b.num;
        result.den = a.den * b.den;
        result.reduFrac();
        return result;
    }

    public static Rational mul(Rational a,Rational b){ //乘法运算
        Rational result = new Rational();
        result.num = a.num * b.num;
        result.den = a.den * b.den;
        result.reduFrac();
        return result;
    }

    public static Rational div(Rational a,Rational b){ //除法运算
        Rational result = new Rational();
        result.num = a.num * b.den;
        result.den = a.den * b.num;
        result.reduFrac();
        return result;
    }

    public void setRational(int num,int den){   //输入分子分母时的赋值函数
        if(den == 0){
            throw new IllegalArgumentException("分母不能为0");
        }
        this.num = num;
        this.den = den;
        this.reduFrac();
    }

    public  void setRational(double number,double delta) { //输入实数和误差范围时的赋值函数，原理同构造函数
        int num =1,den = 1;
        int number_int = 0;
        double number_dec;
        if(number > 1){
            number_int = (int)number/1;
            number_dec = number - number_int;
        }else {
            number_dec = number;
        }
        while (true) {
            if ((double) num / den >= number_dec - delta && (double) num / den <= number_dec + delta) {
                this.num = num+den*number_int;
                this.den = den;
                break;
            }
            else {
                num++;
                if (num >= den) {
                    num = 1;
                    den++;
                }
            }
        }
    }

    public String toString() {    //字符串形式输出一个有理数
        return this.num + "/" + this.den;
    }

    public static void main (String args[]){    //测试该类
        Rational a = new Rational();
        Rational b = new Rational();
        Rational r = new Rational();

        a.setRational(3,6);
        b.setRational(5,6);

        r = div(a,b);

        System.out.println(a.toString()+'\n'+b.toString()+'\n'+r.toString());

        Rational f = new Rational(0.3851,0.29201);
        System.out.println(f.toString());

    }
}

