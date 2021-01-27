public class KVNode{
    private Double value;
    private String data;

    //Empty Constructor
    public KVNode() {
        value = 0.0;
        data = "";
    }

    //Constructor with Data
    public KVNode(Double value, String data) {
         this.value = value;
         this.data = data;
    }

    //Set Value
    public void setValue(double value) {
        this.value = value;
    }
    //Add to the value
    public void addValue(double value) {
        this.value += value;
    }
    //Access Value
    public double getValue() {
        return value;
    }
    //Access Data
    public String getData() {
        return data;
    }
    //Compare
    @Override
    public boolean equals(Object o) {
        if (o.getClass() == getClass()) {
            if (((KVNode)(o)).getData().equals(data) && ((KVNode)(o)).getValue() == (value)) {
                return true;
            }
        }
        return false;
    }
}
