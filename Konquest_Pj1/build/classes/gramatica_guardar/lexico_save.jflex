package gramatica_guardar;
import java_cup.runtime.Symbol;
%%
%class lexico_save
%cup
%cupdebug
%line
%column
%full
%char
%public
/*Identifiers*/
letra=[a-zA-z]
numero=[1-9]
cero=[0]
symbols=[$_-]

%{
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }
%}
%%
<YYINITIAL>{
    "PLANETAS_NEUTRALES"     {return symbol(sym.neutrales,new String(yytext()));}
    "PLANETAS"     {return symbol(sym.planetas,new String(yytext()));}
    "JUGADOR"       {return symbol(sym.jugador,new String(yytext()));}
    "["             {return symbol(sym.abreCor,new String(yytext()));}
    "]"             {return symbol(sym.cierraCor,new String(yytext()));}
    "{"             {return symbol(sym.abreLlaves,new String(yytext()));}
    "}"             {return symbol(sym.cierraLlaves,new String(yytext()));}
    "("             {return symbol(sym.abreParen,new String(yytext()));}
    ")"             {return symbol(sym.cierraParen,new String(yytext()));}
    ","             {return symbol(sym.coma,new String(yytext()));}
    "color"         {return symbol(sym.color,new String(yytext()));}
    "rojo"          {return symbol(sym.rojo,new String(yytext()));}
    "azul"          {return symbol(sym.azul,new String(yytext()));}
    "verde"         {return symbol(sym.verde,new String(yytext()));}
    ":"             {return symbol(sym.dosPuntos,new String(yytext()));}
    "naves"         {return symbol(sym.naves,new String(yytext()));}
    "produccion"    {return symbol(sym.produccion,new String(yytext()));}    
    "dueño"         {return symbol(sym.dueño,new String(yytext()));}
    "datos"         {return symbol(sym.datos,new String(yytext()));}
   
    "posicion"      {return symbol(sym.pos,new String(yytext()));}
    "coord_x"       {return symbol(sym.x,new String(yytext()));}
    "coord_y"       {return symbol(sym.y,new String(yytext()));}
    "nombre"        {return symbol(sym.nombre,new String(yytext()));}
    "\""            {return symbol(sym.comilla,new String(yytext()));}
    "“"                                                         {return symbol(sym.abreComilla,new String(yytext()));}                
    "”"                                                         {return symbol(sym.cierraComilla,new String(yytext()));}
    (({numero}|{cero})({numero}|{cero})*)                       {return symbol(sym.num,new String(yytext()));}    
    ({letra}|{symbols})({letra}|{symbols}|{numero}|{cero})*     {return symbol(sym.id,new String(yytext()));}
    ("\n")|("\t")                                               {}
    (" ")                                                       {}
    .                                                           {return symbol(sym.ERROR,new String(yytext()));}    

}