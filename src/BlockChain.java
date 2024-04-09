import java.security.NoSuchAlgorithmException;
import java.io.PrintWriter;
import java.lang.IllegalArgumentException;
/**
 * A singularly linked blockchain implementation
 *
 * @author David Rhoades
 * @author Zack Abdilah
 */

 public class BlockChain{

  
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  Node first;
  Node last;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  //  creates a BlockChain that possess a single block the starts with the given initial amount.
  public BlockChain(int intial) throws NoSuchAlgorithmException{
    this.first = new Node(new Block(0, intial), null);
    this.last = this.first;
  }

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+


  // mines a new candidate block to be added to the end of the chain.
  Block mine(int amount) throws NoSuchAlgorithmException{
  return new Block(this.last.value.getNum(), amount, this.last.value.getHash());
  }
  // returns the size of the blockchain
  public int getSize(){
    return this.last.value.getNum();
  } // getSize

  // adds this block to the list
  public void append(Block blk) throws IllegalArgumentException{ 
    if (blk.prevHash != this.last.value.getHash()){
      throw new IllegalArgumentException("Invalid block");
    }
    else{
    Node tmp = new Node(blk, null);
     this.last.next = tmp;
     this.last = tmp; 
    }
  } // append
  
  // removes the last block from the chain, returning true. If the chain only contains a single block, then removeLast does nothing and returns false.
  public boolean removeLast(){
    if (this.first == this.last){
      return false;
    else{
      this // start here
    }
    }
  }

  // returns the hash of the last block in the chain.
  public Hash getHash(){

  }

  // alks the blockchain and ensures that its blocks are consistent (the balances are legal) and valid (as in append).
  public boolean isValidBlockChain(

  )

  // prints Alexis’s and Blake’s respective balances
  public void printBalances(PrintWriter pen){

  }

  // eturns a string representation of the BlockChain which is simply the string representation of each of its blocks, earliest to latest, one per line.
  public String toString(){

  }
} // class BlockChain
