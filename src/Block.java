import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * An individual node within a BlockChain
 * 
 * @author David Rhoades
 * @author Zack Abdilah
 */


 public class Block{


  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  int num;
  int amount;
  Hash prevHash;
  long nonce;
  Hash hash;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  // creates a new block from the specified parameters, performing the mining operation to discover the nonce and hash for this block given these parameters
  Block(int num, int amount, Hash prevHash) throws NoSuchAlgorithmException{
    long nonce = -1;
    Hash hash;
    Random rand = new Random();
    do {
      nonce = rand.nextLong();
      if(nonce < 0) {
        nonce *= -1;
      }
      byte[] temp = calculateHash(num, amount, prevHash, nonce);
      hash = new Hash(temp);
    } while (! hash.isValid());

    this.num = num;
    this.amount = amount;
    this.prevHash = prevHash;
    this.nonce = nonce;
    this.hash = hash;
  } // Block

  Block(int num, int amount, Hash prevHash, long nonce) throws NoSuchAlgorithmException{
    this.num = num;
    this.amount = amount;
    this.prevHash = prevHash;
    this.nonce = nonce;
    this.hash = new Hash(calculateHash(num, amount, prevHash, nonce));
  } // Block

  Block(int num, int amount) throws NoSuchAlgorithmException{
    long nonce = -1;
    Hash hash;
    Random rand = new Random();
    do {
      nonce = rand.nextLong();
      if(nonce < 0) {
        nonce *= -1;
      }
      byte[] temp = calculateHash(num, amount, nonce);
      hash = new Hash(temp);
    } while (! hash.isValid());

    this.num = num;
    this.amount = amount;
    this.nonce = nonce;
    this.hash = hash;
  } // Block


  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  //calcluates and returns the has of the given data
  public static byte[] calculateHash(int num, int amount, Hash prevHash, long nonce) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("sha-256");
    md.update(ByteBuffer.allocate(Integer.BYTES).putInt(num).array());
    md.update(ByteBuffer.allocate(Integer.BYTES).putInt(amount).array());
    md.update(prevHash.getData());
    md.update(ByteBuffer.allocate(Long.BYTES).putLong(nonce).array());
    byte[] hash = md.digest(); 
    return hash;
} // calculateHash(String)


  //calcluates and returns the has of the given data
  public static byte[] calculateHash(int num, int amount, long nonce) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("sha-256");
    md.update(ByteBuffer.allocate(Integer.BYTES).putInt(num).array());
    md.update(ByteBuffer.allocate(Integer.BYTES).putInt(amount).array());
    md.update(ByteBuffer.allocate(Long.BYTES).putLong(nonce).array());
    byte[] hash = md.digest(); 
    return hash;
} // calculateHash(String)

  // returns this blocks num
  public int getNum() {
    return num;
  } // getNum

  // returns this blocks Amount
  public int getAmount() {
    return amount;
  } // getAmount

  // returns this blocks prevHash
  public Hash getPrevHash() {
    return prevHash;
  } // getPrevHash

  // returns this blocks nonce
  public long getNonce() {
    return nonce;
  } // getNonce

  // returns this blocks hash
  public Hash getHash() {
    return hash;
  } // getHash

  // returns a string representation of the block
  public String toString() {
    if(this.getPrevHash() != null) {
      return "Block " + this.getNum() + " (Amount: " + this.getAmount() + ", Nonce: " + this.getNonce() + ", prevHash: " + this.getPrevHash().toString() + ", hash: " + this.getHash().toString() +")";
    } else {
      return "Block " + this.getNum() + " (Amount: " + this.getAmount() + ", Nonce: " + this.getNonce() + ", prevHash: null, hash: " + this.getHash().toString() +")";
    }
  } // ToString


} // class Block
