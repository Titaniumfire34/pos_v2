package dev.pos4.pos;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class table {

    private int tableNumber;
    private int numberOfSeats;
    private String description;
    private int status;

    @DocumentReference
    private Ticket tableTicket;

    @Id
    private ObjectId id;
    

    public table(int tNum, int sNum) { 
        this.tableNumber = tNum;
        this.numberOfSeats = sNum;
        this.status = 0;
        this.tableTicket = null;
        this.description = "";
    }

    public void setTableNumber(int tableNum) {
        if(tableNum <= 99 && tableNum >= 0) {
            this.tableNumber = tableNum;
            if(this.tableTicket != null){
                this.tableTicket.setTableNum(tableNum);
            }
        }  
    }

    public void setTableDescription(String description) {
            this.description = description;
    }

    public void setTableTicketStatus(int status) {
        if(status >= 0 && status <= 5) {
            this.status = status;
        }
    }

    public void setNumberOfSeats(int numSeats) {
        if(numSeats <= 50 && numSeats >= 0) {
            this.numberOfSeats = numSeats;
        }
    }

    public void setTicket(Ticket t) {
        if(t.getTableNum() == this.tableNumber) {
            this.tableTicket = t;
        }
    }

    public int getTicketStatus() {
        return this.status;
    }
    
    public String getDescription() {
        return this.description;
    }

    public Ticket getTicket() {          
        return this.tableTicket;
    }

    public int getTableNumber() {
        return this.tableNumber;
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }
}
