package ua.prog.kiev.lesson1.taskThree;

public class MainTaskThree {

    private static void SerializeDeserializeAnnotatedFields() {
        SerializedClass instanceSerializedClass = new SerializedClass();
        SerializeDeserialize instanceSerializeDeserialize = new SerializeDeserialize(instanceSerializedClass);

        System.out.println("\n======Get Initial Values======");
        System.out.println("Field strOne = " + instanceSerializedClass.getStrOne());
        System.out.println("Field doubleOne = " + instanceSerializedClass.getDoubleOne());
        System.out.println("Field intTwo = " + instanceSerializedClass.getIntTwo());
        System.out.println("Field integer = " + instanceSerializedClass.getInteger());


        System.out.println("\n======Serializing======");
        instanceSerializeDeserialize.serializeAnnotatedFields();
        System.out.println("==========Done=========");

        System.out.println("\n=======Set New Values========");
        System.out.println("==strOne, doulbeOne, intTwo==");
        instanceSerializedClass.setStrOne("AHAHH");
        instanceSerializedClass.setDoubleOne(11.11);
        instanceSerializedClass.setIntTwo(10101);
        System.out.println("============Done=============");

        System.out.println("\n======Get Changed Values======");
        System.out.println("Field strOne = " + instanceSerializedClass.getStrOne());
        System.out.println("Field doubleOne = " + instanceSerializedClass.getDoubleOne());
        System.out.println("Field intTwo = " + instanceSerializedClass.getIntTwo());
        System.out.println("Field integer = " + instanceSerializedClass.getInteger());

        System.out.println("\n======DeSerializing======");
        instanceSerializeDeserialize.deSerializeAnnotatedFields();
        System.out.println("===========Done==========");

        System.out.println("\n======Get Restored Values======");
        System.out.println("Field strOne = " + instanceSerializedClass.getStrOne());
        System.out.println("Field doubleOne = " + instanceSerializedClass.getDoubleOne());
        System.out.println("Field intTwo = " + instanceSerializedClass.getIntTwo());
        System.out.println("Field integer = " + instanceSerializedClass.getInteger());


    }

    public static void main(String[] args) {
        SerializeDeserializeAnnotatedFields();
    }

}
