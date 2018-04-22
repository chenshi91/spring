package designpattern.adapter;

/**
 * auther:chenshi
 * date:2018-03-25 21:42
 * package:designpattern.adapter
 * 采用组合的方式，适配器（常用，扩展性强）
 */
public class TwoPlugAdapter implements ThreePlugIf {
    private GBTwoPlug gbTwoPlug;

    public TwoPlugAdapter(GBTwoPlug twoPlug) {
        this.gbTwoPlug=twoPlug;
    }

    @Override
    public void powerByThree() {
        System.out.println("通过转换");
        gbTwoPlug.powerByTwo();
    }
}
