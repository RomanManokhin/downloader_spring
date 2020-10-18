package Task01;

import java.util.*;

public class StreamLambda {

    ArrayList<Integer> arrayList = new ArrayList<>();


    ArrayList<Integer> addList(Integer ... list){
        Collections.addAll(arrayList, list);
        return streamFilter(arrayList);
    }

    ArrayList<Integer> streamFilter(ArrayList<Integer> list){
        ArrayList<Integer> temp = (ArrayList<Integer>) arrayList.clone();
        list.clear();
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i) % 2 == 0){
                list.add(temp.get(i));
            }
        }
        return streamMap(arrayList);
    }

    ArrayList<Integer> streamMap(ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) * list.get(i));
        }

        return streamDistinct(list);
    }

    ArrayList<Integer> streamDistinct(ArrayList<Integer> list){
        TreeSet<Integer> temp = new TreeSet<>(list);
        list.clear();
        list.addAll(temp);


        return list;
    }


    @Override
    public String toString() {
        return "StreamLambda{" +
                "arrayList=" + arrayList +
                '}';
    }
}



