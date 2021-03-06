package BD;

import Tipos.Compromisso;
import Tipos.Usuario;
import java.util.ArrayList;


/*
 *
 * @author Rizzadinha
 */
public class GerenciadorBD {
    
   static SQLiteJDBCD banco = new SQLiteJDBCD();
    
    //Compromisso    
    public  static void inserirCompromisso(Compromisso compromissoBD){
        
        banco.connect();
        banco.criaTabelaCompromisso();
        banco.inserirCompromisso(compromissoBD);
        //banco.selecionaDados();
        banco.closeConnect();
        
    }
    
    public static void alterarCompromisso(Compromisso compromissoBD, String dataGBD, String nomeGBD,int idFKGBD){
        
        banco.connect();
        
        banco.alterarCompromisso(compromissoBD, dataGBD, nomeGBD, idFKGBD);
        
        banco.closeConnect();
    }
    
    public static void deletarCompromisso(String dataGBD,String nomeGBD,int idFKGBD){
        
        banco.connect();
        
        banco.deletarCompromisso(dataGBD, nomeGBD,idFKGBD);
        
        banco.closeConnect();
        
        
    }
    
    public static  ArrayList<Compromisso> listarUltimos(int idFKGBD, String dataAtualGBD){
        
        ArrayList<Compromisso> GBDLista = new ArrayList<Compromisso>();
        banco.connect();
        
        GBDLista = banco.selecionaCompromissoUltimos(idFKGBD, dataAtualGBD);
       
        banco.closeConnect();
        
        return GBDLista;
        
    }
    
    public static  ArrayList<Compromisso> listarNomes(String nomeGBD,int idFKGBD, String dataAtualGBD){
        
        ArrayList<Compromisso> GBDLista = new ArrayList<Compromisso>();
        banco.connect();
        
        GBDLista = banco.selecionaCompromissoNomes(nomeGBD,idFKGBD,dataAtualGBD);
      
        banco.closeConnect();
        
        return GBDLista;
        
    }
    
    public static  ArrayList<Compromisso> listarDatas(String dataGBD,int idFKGBD){
        
        ArrayList<Compromisso> GBDLista = new ArrayList<Compromisso>();
        banco.connect();
        
        GBDLista = banco.selecionaCompromissoData(dataGBD,idFKGBD);
             
        banco.closeConnect();
        
        return GBDLista;
        
    }
    
    public static  Compromisso auxAlterar(String nomeGBD, String dataGBD, int idFKGBD){
       
        
        banco.connect();
        
        Compromisso cGBD = banco.selecionaCompromissoAlterar(nomeGBD, dataGBD, idFKGBD);
    
        banco.closeConnect();
        
        return cGBD;  
        
    }
            

    //Usuário
    public static void inserirUusuario(Usuario usuarioGBD){
        
        banco.connect();
        banco.criaTabelaUsuario();
        banco.inserirUsuario(usuarioGBD);
        
        banco.closeConnect();
        
        
    }
    
    public static void alterarUsuario(Usuario usuarioGBD, String loginGBD, String senhaGBD){
        
        banco.connect();
        
        banco.alterarUsuario(usuarioGBD, loginGBD, senhaGBD);
        
        banco.closeConnect();
        
    }
    
    public static void deletarUsuario(String loginGBD,String senhaGBD){
        
        banco.connect();
        
        banco.deletarUsuario(loginGBD, senhaGBD);
        
        banco.closeConnect();
        
        
    }
      
    public static Usuario selecionaAlterarU(String loginGBD, String senhaGBD){
  
        banco.connect();
        
        Usuario uGBD = banco.selecionaUsuario(loginGBD, senhaGBD);
    
        banco.closeConnect();
                
        return uGBD; 
        
    }
    
    public static  ArrayList<Usuario> listarUsuarioTodos(){
        
        ArrayList<Usuario> GBDLista = new ArrayList<Usuario>();
        banco.connect();
        
        GBDLista = banco.selecionaDadosUsuarioTodos();
      
        banco.closeConnect();
        
        return GBDLista;
        
        
    }
    
    
    //Check
    public static boolean checkLogin(String loginGBD, String senhaGBD){
        
        banco.connect();
       
        boolean validaGBD = banco.validaLogin(loginGBD, senhaGBD);
        
        banco.closeConnect();
        
        return validaGBD;
    }
    
    public static boolean checkExistente(String usuarioGBD){
        
        banco.connect();
       
        boolean validaGBD = banco.validaUsuarioExistente(usuarioGBD);
        
        banco.closeConnect();
        
        return validaGBD;
        
    }
    
    
}
