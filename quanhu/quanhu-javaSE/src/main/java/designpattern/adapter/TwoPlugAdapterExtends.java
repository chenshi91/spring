package designpattern.adapter;

/**
 * auther:chenshi
 * date:2018-03-25 21:55
 * package:designpattern.adapter
 * 采用继承的方式，适配器
 */
public class TwoPlugAdapterExtends extends GBTwoPlug implements ThreePlugIf{

    @Override
    public void powerByThree() {
        super.powerByTwo();
    }
}
