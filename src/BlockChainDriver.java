import java.lang.Integer;
import java.lang.Long;
import java.io.PrintWriter;
import java.lang.NumberFormatException;
import java.util.Scanner;
import java.security.NoSuchAlgorithmException;
/**
 * Allows for interaction with BlockChain
 *
 * @author David Rhoades
 * @author Zack Abdilah
 */

 public class BlockChainDriver{

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

public static void main(String[] args) {
  Integer input = null;
  PrintWriter pen = new PrintWriter(System.out);
  
  //Check initial input
  if(args.length != 1) {
    pen.println("Invalid argument, please call with one integer argument");
    pen.flush();
    return;
  }
  try {
    input = Integer.parseInt(args[0]);
  } catch(NumberFormatException e) {
    pen.println("Invalid argument, please call with one integer argument");
    pen.flush();
    return;
  }
  Scanner reader = new Scanner(System.in);
   
  try {
  BlockChain chain = new BlockChain(input);
  
  String str = "";
  String amt;
  String nonce;
  Block blk;

  do {
    if(str.equals("help")) {
      pen.println("Valid commands:");
      pen.println("   mine: discovers the nonce for a given transaction");
      pen.println("   append: appends a new block onto the end of the chain");
      pen.println("   remove: removes the last block from the end of the chain0");
      pen.println("   check: checks that the block chain is valid");
      pen.println("   report: reports the balances of Alexis and Blake");
      pen.println("   help: prints this list of commands");
      pen.println("   quit: quits the program");
      pen.flush();

    } else if(str.equals("mine")) {
      pen.print("Amount transferred? ");
      pen.flush();
      amt = reader.nextLine();
      blk = chain.mine(Integer.parseInt(amt));
      pen.println("amount = " + amt + ", nonce = " + blk.getNonce());
      pen.flush();
    } else if(str.equals("append")) {
      pen.print("Amount transferred? ");
      pen.flush();
      amt = reader.nextLine();
      pen.print("Nonce? ");
      pen.flush();
      nonce = reader.nextLine();
      chain.append(new Block(chain.getSize(), Integer.parseInt(amt), chain.getHash(), Long.parseLong(nonce)));
    
    } else if(str.equals("remove")) {
      if(!chain.removeLast()) {
        pen.println("Cannot remove from a chain with only one block");
        pen.flush();
      }
    } else if(str.equals("check")) {
      if(chain.isValidBlockChain()) {
        pen.println("Chain is valid!");
        pen.flush();
      } else {
        pen.println("Chain is invalid!");
        pen.flush();
      }
    } else if(str.equals("report")) {
      chain.printBalances(pen);
      pen.flush();
    } else if(str.equals("quit")) {
      break;
    } else if(str.equals("")) {
    } else {
      pen.println("Invalid command, type \"help\" to see all valid commands");
      pen.flush();
    }
    pen.println("\n" + chain.toString());
    pen.print("Command? ");
    pen.flush();
    str = reader.nextLine();

      
    } while(!str.equals("quit"));
    
  } catch(NoSuchAlgorithmException e) {
    pen.println("Invalid algorithm");
    pen.flush();
  }
    reader.close();
  }
} // BlockChainDriver
