/**
 * An individual node within a BlockChain
 * 
 * @author David Rhoades
 * @author Zack Abdilah
 */


import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

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

  //: creates a new block from the specified parameters, performing the mining operation to discover the nonce and hash for this block given these parameters
  Block(int num, int amount, Hash prevHash) throws NoSuchAlgorithmException{
    long nonce = -1;
    Hash hash;
    Random rand = new Random();
    do {
      nonce = rand.nextLong();
      byte[] temp = calculateHash(num, amount, prevHash, nonce);
      hash = new Hash(temp);
    } while (! hash.isValid());

    this.num = num;
    this.amount = amount;
    this.prevHash = prevHash;
    this.nonce = nonce;
    this.hash = hash;
  }

  Block(int num, int amount, Hash prevHash, long nonce) throws NoSuchAlgorithmException{
    this.num = num;
    this.amount = amount;
    this.prevHash = prevHash;
    this.nonce = nonce;
    this.hash = new Hash(calculateHash(num, amount, prevHash, nonce));
  }

  Block(int num, int amount) throws NoSuchAlgorithmException{
    long nonce = -1;
    Hash hash;
    Random rand = new Random();
    do {
      nonce = rand.nextLong();
      byte[] temp = calculateHash(num, amount, nonce);
      hash = new Hash(temp);
    } while (! hash.isValid());

    this.num = num;
    this.amount = amount;
    this.nonce = nonce;
    this.hash = hash;
  }


  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  //calcluates and returns the has of the given data
  public static byte[] calculateHash(int num, int amount, Hash prevHash, long nonce) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("sha-256");
    ByteBuffer bb = ByteBuffer.allocate(64);
    md.update(bb.putInt(num));
    md.update(bb.putInt(0, amount));
    md.update(prevHash.getData());
    md.update(bb.putLong(0, nonce));
    byte[] hash = md.digest(); 
    return hash;
} // calculateHash(String)


  //calcluates and returns the has of the given data
  public static byte[] calculateHash(int num, int amount, long nonce) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("sha-256");
    ByteBuffer bb = ByteBuffer.allocate(64);
    md.update(bb.putInt(num));
    md.update(bb.putInt(0, amount));
    md.update(bb.putLong(0, nonce));
    byte[] hash = md.digest(); 
    return hash;
} // calculateHash(String)

  // returns this blocks num
  public int getNum() {
    return num;
  }

  // returns this blocks Amount
  public int getAmount() {
    return amount;
  }

  // returns this blocks prevHash
  public Hash getPrevHash() {
    return prevHash;
  }

  // returns this blocks nonce
  public long getNonce() {
    return nonce;
  }

  // returns this blocks hash
  public Hash getHash() {
    return hash;
  }

  // returns a string representation of the block
  public String toString() {
    return "Block" + this.getNum() + " (Amount: " + this.getAmount() + ", Nonce: " + this.getNonce() + ", prevHash: " + this.getPrevHash().toString() + ", hash: " + this.getHash().toString() +")";

  }


} // class Hash
