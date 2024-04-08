/**
 * An individual node within a BlockChain
 * 
 * @author David Rhoades
 * @author Zack Abdilah
 */


import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
  Block(int num, int amount, Hash prevHash) {
    this.num = num;
    this.amount = amount;
    this.prevHash = prevHash;
    // add mining
  }

  Block(int num, int amount, Hash prevHash, long nonce) {
    this.num = num;
    this.amount = amount;
    this.prevHash = prevHash;
    this.nonce = nonce;
    //need to finish (set hash)
  }


  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  public static byte[] calculateHash(int num, int amount, Hash prevHash, long nonce) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("sha-256");
    ByteBuffer bb = ByteBuffer.allocate(64);
    md.update(bb.putInt(num));
    md.update(bb.putInt(0, amount));

    md.update(0, prevHash.getData());
    byte[] hash = md.digest(); //start here
    return hash;
} // calculateHash(String)

  //returns this blocks num
  public int getNum() {
    return num;
  }

  //returns this blocks Amount
  public int getAmount() {
    return amount;
  }

  //returns this blocks prevHash
  public Hash getPrevHash() {
    return prevHash;
  }

  //returns this blocks nonce
  public long getNonce() {
    return nonce;
  }

  //returns this blocks hash
  public Hash getHash() {
    return hash;
  }


} // class Hash
