import java.util.Arrays;


/**
 * Sort using merge sort.
 *
 * @author David Rhoades
 * @author Zack Abdilah
 */

public class Hash{


  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  byte[] byteArray;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  // constructs a new Hash object that contains the given hash (as an array of bytes)
  public Hash(byte[] data){
    this.byteArray = data;

  }// Hash Method

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  //returns the hash contained in this object.
  public byte[] getData(){
    return this.byteArray;
  }

  //returns true if this hash meets the criteria for validity, i.e., its first three indices contain zeroes.
  public boolean isValid(){
    return (this.byteArray[0] == 0 && this.byteArray[1] == 0 && this.byteArray[2] == 0);
  }

  //returns the string representation of the hash as a string of hexadecimal digits, 2 digits per byte.
  public String toString(){
    String tmp = "";
    for (int i = 0; i < this.byteArray.length; i++) {
      tmp += String.format("%02x", Byte.toUnsignedInt(this.byteArray[i]));
    }
    return tmp;
  }

  //returns true if this hash is structurally equal to the argument.
  public boolean equals(Object other) {
    return (other instanceof Hash) && (Arrays.equals(((Hash)other).getData(), this.getData()));
  }
} // class Hash
