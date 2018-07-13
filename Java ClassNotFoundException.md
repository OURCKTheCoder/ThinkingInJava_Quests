# 关于终端运行Java报找不到类的问题

java不支持-cp参数？？？？

通过指定-cp，可以让javac在指定的目录中搜索所需要的类文件
并编译成字节码。
就算是位于工作目录之外的目录也没问题。

但，java命令就算带-cp参数，
手工指定了资源地址，也仍然不会运行成功，
报错java.lang.NoClassDefFoundError

似乎java命令只会在当前工作空间及其子目录下
寻找编译好的.class文件并运行？？？？？、


解决：
_____
 javac -cp some.jar XXX.javac
 java -cp some.jar XXX.javac
-cp 必须是第一个参数
这样就能解决问题。2333

