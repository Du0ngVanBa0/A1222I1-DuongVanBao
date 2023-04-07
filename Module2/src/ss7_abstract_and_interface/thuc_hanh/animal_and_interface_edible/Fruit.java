package ss7_abstract_and_interface.thuc_hanh.animal_and_interface_edible;

public abstract class Fruit implements Edible {

    @Override
    public String howtoEat() {
        return "mlem mlem";
    }
}
