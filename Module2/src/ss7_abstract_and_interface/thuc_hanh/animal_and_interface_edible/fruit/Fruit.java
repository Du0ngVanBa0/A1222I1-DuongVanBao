package ss7_abstract_and_interface.thuc_hanh.animal_and_interface_edible.fruit;

import ss7_abstract_and_interface.thuc_hanh.animal_and_interface_edible.edible.Edible;

public abstract class Fruit implements Edible {

    @Override
    public String howToEat() {
        return "mlem mlem";
    }
}
