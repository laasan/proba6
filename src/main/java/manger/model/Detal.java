package manger.model;

import javax.persistence.*;

@Entity
@Table(name = "detal")
public class Detal {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "need")
    private boolean need;

    @Column(name = "amount")
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNeed() {
        return need;
    }

    public void setNeed(boolean need) {
        this.need = need;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "detal{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", need='" + need + '\'' +
                ", amount=" + amount +
                '}';
    }
}
