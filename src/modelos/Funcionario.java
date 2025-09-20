/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author aluno
 */
public class Funcionario {
    //  atributos
    private int matricula = 0;
    private String nome = "";
    private int numDeDependetes = 0;
    private float salarioBase = 0;
    private int valorGp = 0;
    
    
// metodos
public Funcionario(int matricula, String nome, int numDeDependentes, float salarioBase, int valorGp)throws Exception{
    if(matricula < 0) throw new Exception("Matricula não pode ser menor que zero");
    if(numDeDependentes < 0) throw new Exception("num. de dependentes não pode ser menor que zero");
    if(salarioBase < 0) throw new Exception("salario base não pode ser menor que zero");
    if(valorGp < 0) throw new Exception("ValorGp não pode ser menor que zero");
    
    this.matricula = matricula;
    this.nome = nome;
    this.numDeDependetes = numDeDependentes;
    this.salarioBase = salarioBase;
    this.valorGp = valorGp;
}
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getnumDeDependetes() {
        return numDeDependetes;
    }

    public void setnumDeDependetes(int numDeDependetes) {
        this.numDeDependetes = numDeDependetes;
    }

    public float getsalarioBase() {
        return salarioBase;
    }

    public void setsalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getValorGp() {
        return valorGp;
    }

    public void setValorGp(int valorGp) {
        this.valorGp = valorGp;
    }
    
    public float calcularsalariobruto(){
    return (salarioBase+valorGp + exibirContracheque());
}
    public float descontoPdependetes(){
        return(numDeDependetes *123);
    }
    public float calcularDescontoIRPF(){
        float aliquota1 = 0;
        if(calcularsalariobruto() < 2259.21f) return aliquota1;
        if(calcularsalariobruto() >= 2259.21f && calcularsalariobruto() <= 2826.65f) aliquota1 = (float) 0.075 ;
        if(calcularsalariobruto() >= 2826.66f && calcularsalariobruto() <= 3751.05f) aliquota1 = (float) 0.15;
        if(calcularsalariobruto() >= 3471.06f && calcularsalariobruto() <= 4664.68) aliquota1 = (float) 0.227;
        if(calcularsalariobruto() > 4664.68) aliquota1 = 0.275f;
        float descontoIrpf = aliquota1 * ( salarioBase - (numDeDependetes * 123));
        return descontoIrpf;
        
    }
   
   public float calcularDescontoINSS(){
     float aliquota = 0;
     if(calcularsalariobruto() <= 1412f) aliquota = 0.075f;
     if(calcularsalariobruto() >= 1412.01f && calcularsalariobruto() <= 2666.68f) aliquota = 0.09f;
     if(calcularsalariobruto() >= 2666.69f && calcularsalariobruto() <= 4000.03f) aliquota = 0.12f;
     if(calcularsalariobruto() > 4000.03f) aliquota = 0.14f;
     float descontoInss = calcularsalariobruto() * aliquota;
     return descontoInss;
   }
    
   
    public float exibirContracheque(){
        float exibir = 0;
        if(valorGp <= 1000)return exibir + 500;
        if(valorGp >= 1001 && valorGp <= 2000) return exibir + 1250;
        return exibir + 2250;
    }
     
    public float calcularSalarioLiquido(){
        float salarioLiquido = (calcularsalariobruto() - calcularDescontoINSS() - calcularDescontoIRPF());
        return salarioLiquido;
        
        
    }

}
