package lista;

public class List {
    
    private Node root;
    protected int count;
    
    public List(){
        root = null;
        count = 0;
    }
    
    public List(int date){
        root = new Node(date);
        count++;
    }
    
    public void append(int date){
        if(root == null){
            root = new Node(date);
            count++;
        }else{
            Node aux = root;
            while(aux.next != null){
                aux = aux.next;
            }
            aux.next = new Node(date);
            count++;
        }
    }
    
    public void insert(int position, int date){
        if(position >= count){
            append(date);
        }else{
            position--;
            if(position == 0){
                Node aux = new Node(date);
                aux.next = root;
                root = aux;
                count++;
            }else{
                int auxcount = 0;
                Node aux = root;
                while(auxcount < position){
                    aux = aux.next;
                    auxcount++;
                }
                Node aux2 = new Node(date);
                aux2.next = aux.next;
                aux.next = aux2;
                count++;
            }
        }
    }
    
    public boolean remove(int date){
        if(root.date == date){
            root = root.next;
            count--;
            return true;
        }else{
            Node aux = root;
            while(aux.next != null){
                if(aux.next.date == date){
                    aux.next = aux.next.next;
                    count--;
                    return true;
                }else{
                    aux = aux.next;
                }
            }
        }
        return false;
    }
    
    public int pop(){
        if(root == null){
            return -1;
        }
        if(count == 1){
            int date = root.date;
            count--;
            root = null;
            return date;
        }
        Node aux = root, aux2 = aux;
        while(aux.next != null){
            aux2 = aux;
            aux = aux.next;
        }
        int date = aux.date;
        count--;
        aux2.next = null;
        return date;
    }
    
    public int pop(int position){
        if(position >= count){
            return pop();
        }
        if(position == 0){
            int date = root.date;
            root = root.next;
            count--;
            return date;
        }
        position--;
        Node aux = root;
        int auxcount = 0;
        while(auxcount < position){
            aux = aux.next;
            auxcount++;
        }
        int date = aux.next.date;
        aux.next = aux.next.next;
        count--;
        return date;
    }
    
    public void clear(){
        root = null;
        count = 0;
    }
    
    public void show(){
        if(root != null){
            Node aux = root;
            while(aux.next != null){
                System.out.print("["+aux.date+"]->");
                aux = aux.next;
            }
            System.out.print("["+aux.date+"]->null\n");
        }else{
            System.out.println("no hay datos");
        }
    }
    
    public int count(int date){
        if(count == 0) return 0;
        int coun = 0;
        Node aux = root;
        while(aux.next != null){
            if(aux.date == date){
                coun++;
            }
            aux = aux.next;
        }
        return coun;
    }
    
    public int count(){
        return count;
    }
    
    public void reverse(){
        if(count > 1){
            if(count == 2){
                Node aux = root;
                Node aux2 = root.next;
                aux2.next = aux;
                aux.next = null;
                aux = aux2;
                root = aux;
            }else{
                Node aux = root;
                Node aux2 = root.next;
                Node aux3 = aux2.next;
                aux2.next = aux;
                aux.next = null;
                aux = aux2;
                aux2 = aux3;
                while(aux3.next != null){
                    aux3 = aux3.next;
                    aux2.next = aux;
                    aux = aux2;
                    aux2 = aux3;
                }
                aux2.next = aux;
                aux = aux2;
                root = aux;
            }
        }
    }
    
    public void extend(List list){
        while(list.count() > 0){
            append(list.pop(0));
        }
    }
    
}
