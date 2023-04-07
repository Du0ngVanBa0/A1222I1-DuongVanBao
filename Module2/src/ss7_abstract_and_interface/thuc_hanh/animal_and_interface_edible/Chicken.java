package ss7_abstract_and_interface.thuc_hanh.animal_and_interface_edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "CUc TAc";
    }

    @Override
    public String howtoEat() {
        return "mlem mlem ga`";
    }
}
