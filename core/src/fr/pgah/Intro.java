package fr.pgah;



import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Intro extends ApplicationAdapter {
  SpriteBatch batch; //définition d'une variable
  // SpriteBatch type de variable -si commence par maj varible type object
  double facteurTaille = 0.39;
  int vitesse = 3;
  int hauteurFenetre;
  int hauteurImage;
  boolean onmontex;                      //int dircetionENx;
  boolean onmontey;                      //int dircetionENy;
  Texture img;
  int y;
  int x;
  int longueurEffective;
  int largeurFenetre;
  int hauteurEffective;


  @Override
  public void create() {  
  // create() nom
  batch = new SpriteBatch();
                                 //méthode
    img = new Texture("prototipe 3.jpg") ;//corp de méthode
    longueurEffective = (int) (this.img.getWidth() * facteurTaille);
    hauteurEffective = (int) (this.img.getHeight() * facteurTaille);
    y = 100;
    x = 100;
    hauteurFenetre = Gdx.graphics.getHeight();
    largeurFenetre = Gdx.graphics.getWidth();
    hauteurImage = hauteurEffective;
  }

  

  @Override
  public void render() {
    fondecran();
     //appel de méthode sur l'object batch
    //y ++;
    // x ++;
    testetBordures();
    déplacement();
    dessiner();
  }



  private void fondecran() {
    ScreenUtils.clear(0, 0, 0, 1);
  }



  private void dessiner() {
    batch.begin();
    batch.draw(img, y,  x, longueurEffective, hauteurEffective);
    batch.end();
  }



  private void déplacement() {
    if (onmontex){
        x = x + vitesse;} 
        else{
        x = x -vitesse;
      }

    if (onmontey){
      y = y +vitesse;} 
      else{
        y = y -vitesse;
      } 
  }



  private void testetBordures() { 
    testebordureverticale();
    testebordurehorizontale();
  }



  private void testebordurehorizontale() {
    if (y + longueurEffective >= largeurFenetre){
      onmontey = false;
    }
    if(y <= 0){
      onmontey=true;
    }
  }



  private void testebordureverticale() {
    if (x + hauteurEffective >= hauteurFenetre){
      onmontex=false;
    }
    if (x <= 0){
      onmontex=true;
    }
  }
}
