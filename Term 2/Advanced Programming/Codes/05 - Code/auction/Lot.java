/**
 * A class to model an item (or set of items) in an
 * auction: a lot.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class Lot
{
    // A unique identifying number.
    private final int number;
    // A description of the lot.
    private String description;
    // The current highest bid for this lot.
    private Bid highestBid;

    /**
     * Construct a Lot, setting its number and description.
     * @param number The lot number.
     * @param description A description of this lot.
     */
    public Lot(int number, String description)
    {
        this.number = number;
        this.description = description;
    }

    /**
     * Attempt to bid for this lot. A successful bid
     * must have a value higher than any existing bid.
     * @param bid A new bid.
     * @return true if successful, false otherwise
     */
    public boolean bidFor(Bid bid)
    {
        if((highestBid == null) ||
               (bid.getValue() > highestBid.getValue())) {
            // This bid is the best so far.
            highestBid = bid;
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * @return A string representation of this lot's details.
     */
    public String toString()
    {
        String details = number + ": " + description;
        if(highestBid != null) {
            details += "    Bid: " + 
                       highestBid.getValue();
        }
        else {
            details += "    (No bid)";
        }
        return details;
    }

    /**
     * @return The lot's number.
     */
    public int getNumber()
    {
        return number;
    }

    /**
     * @return The lot's description.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @return The highest bid for this lot.
     *         This could be null if there is
     *         no current bid.
     */
    public Bid getHighestBid()
    {
        return highestBid;
    }
}
