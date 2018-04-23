package designpattern.adapter;

/**
 * auther:chenshi
 * date:2018-03-25 21:36
 * package:designpattern.adapter
 */
public class NoteBook {
    private ThreePlugIf threePlugIf;

    public NoteBook(ThreePlugIf threePlugIf) {
        this.threePlugIf = threePlugIf;
    }

    public void charge(){
        threePlugIf.powerByThree();
    }

    public static void main(String[] args){
        GBTwoPlug twoPlug = new GBTwoPlug();
        ThreePlugIf three=new TwoPlugAdapter(twoPlug);
        NoteBook noteBook = new NoteBook(three);
        noteBook.charge();
    }


}
