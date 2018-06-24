package ua.prog.kiev.lesson1.taskThree;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class SerializeDeserialize {
    private String filePath = "C:/Java/file.obj";
    private SerializedClass instanceSerializedClass;

    public SerializeDeserialize() {

    }

    public SerializeDeserialize(SerializedClass instanceSerializedClass) {
        this.instanceSerializedClass = instanceSerializedClass;
    }

    public void deSerializeAnnotatedFields() {
        List<Object[]> fieldsData = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            fieldsData = (List<Object[]>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class<?> checkedClass = instanceSerializedClass.getClass();

        for (Object[] fieldData : fieldsData) {
            try {
                Field field = checkedClass.getDeclaredField((String) fieldData[1]);
                if (Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                }
                field.set(instanceSerializedClass, fieldData[2]);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Field> getAnnotatedFields() {
        Class<?> checkedClass = instanceSerializedClass.getClass();
        Field[] allFields = checkedClass.getDeclaredFields();
        List<Field> annotatedFields = new ArrayList<>();
        for (Field field : allFields) {
            if (field.isAnnotationPresent(Save.class)) {
                if (Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                }
                annotatedFields.add(field);
            }
        }
        return annotatedFields;
    }

    private List<Object[]> prepareFieldsForSerializing(List<Field> annotatedFields) {
        // format for each field: <Type, Name, Value>
        List<Object[]> preparedFieldsForSerializing = new ArrayList<>();
        for (Field field : annotatedFields) {
            Object[] fieldData = new Object[3];
            fieldData[0] = field.getType();
            fieldData[1] = field.getName();
            if (Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);
            }

            try {
                if (field.getType() == int.class) {
                    fieldData[2] = field.getInt(instanceSerializedClass);
                }
                if (field.getType() == Integer.class) {
                    fieldData[2] = field.get(instanceSerializedClass);
                }

                if (field.getType() == double.class) {
                    fieldData[2] = field.getDouble(instanceSerializedClass);
                }
                if (field.getType() == String.class) {
                    fieldData[2] = (String) field.get(instanceSerializedClass);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            preparedFieldsForSerializing.add(fieldData);
        }
        return preparedFieldsForSerializing;
    }

    public void serializeAnnotatedFields() {
        List<Field> annotatedFields = getAnnotatedFields();
        List<Object[]> preparedFieldsForSerializing = prepareFieldsForSerializing(annotatedFields);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(preparedFieldsForSerializing);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
