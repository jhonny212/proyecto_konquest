package gramaticaReplay;
import java_cup.runtime.Symbol;
%%
%class lexico_replay
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
    "turno"         {return symbol(sym.turno,new String(yytext()));}
    "["             {return symbol(sym.abreCor,new String(yytext()));}
    "]"             {return symbol(sym.cierraCor,new String(yytext()));}
    "{"             {return symbol(sym.abreLlaves,new String(yytext()));}
    "}"             {return symbol(sym.cierraLlaves,new String(yytext()));}
    ","             {return symbol(sym.coma,new String(yytext()));}
    ":"             {return symbol(sym.dosPuntos,new String(yytext()));}
    "naves"         {return symbol(sym.naves,new String(yytext()));}
    "datos"         {return symbol(sym.datos,new String(yytext()));}
    "nombre"        {return symbol(sym.nombre,new String(yytext()));}
    "galaxias"      {return symbol(sym.espacio,new String(yytext()));}
    "origen"        {return symbol(sym.origen,new String(yytext()));}
    "destino"       {return symbol(sym.destino,new String(yytext()));}
    "complete"      {return symbol(sym.complete,new String(yytext()));}
    "numeroTurno"   {return symbol(sym.numeroTurno,new String(yytext()));}
    "ataque"   {return symbol(sym.ataque,new String(yytext()));}
    
    ("true")|("false")                                          {return symbol(sym.bool,new String(yytext()));}
    "\""            {return symbol(sym.comilla,new String(yytext()));}
    "“"                                                         {return symbol(sym.abreComilla,new String(yytext()));}                
    "”"                                                         {return symbol(sym.cierraComilla,new String(yytext()));}
    (({numero}|{cero})({numero}|{cero})*)                       {return symbol(sym.num,new String(yytext()));}    
    ({letra}|{symbols})({letra}|{symbols}|{numero}|{cero})*     {return symbol(sym.id,new String(yytext()));}
    ("\n")|("\t")                                               {}
    (" ")                                                       {}
    .                                                           {return symbol(sym.ERROR,new String(yytext()));}    

}
