package Gerenciadores;

import com.example.brinquedo1.EtapasActivity;
import com.example.brinquedo1.Fase02;
import com.example.brinquedo1.GameActivity;
import com.example.brinquedo1.R;
import com.example.brinquedo1.Scene;
import com.example.brinquedo1.Vitoria;

import ETAPA1.Fase1_Assets;
import ETAPA1.Fase2_Assets;
import ETAPA1.Fase3_Assets;
import ETAPA1.Fase4_Assets;
import ETAPA1.Fase5_Assets;
import ETAPA1.Fase6_Assets;
import ETAPA1.Fase7_Assets;
import ETAPA1.Fase8_Assets;
import ETAPA1.Fase9_Assets;
import ETAPA2.Fase1_Assets_ETAPA2;
import ETAPA2.Fase2_Assets_ETAPA2;
import ETAPA2.Fase3_Assets_ETAPA2;
import ETAPA2.Fase4_Assets_ETAPA2;
import ETAPA2.Fase5_Assets_ETAPA2;
import ETAPA2.Fase6_Assets_ETAPA2;
import ETAPA2.Fase7_Assets_ETAPA2;
import ETAPA2.Fase8_Assets_ETAPA2;
import ETAPA2.Fase9_Assets_ETAPA2;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

public class SceneManager {
	static private SCENE currentScene;
	static public Fase02 scene = null;
	public static Scene carregar;

	public static Activity activity;

	public static Thread processo;
	public static Boolean sound=true;

	static public void Setup(Activity game, int etapa, int fase, Thread processo) {
		if (etapa == 1) {


			carregarSceneEtapa1(fase, game);


		}
		if (etapa == 2) {
			carregarSceneEtapa2(fase,game);
		}


		Intent mod = new Intent((Context)game,GameActivity.class);
		game.startActivity(mod);
	
		SceneManager.processo=processo;
		
		
		activity = game;
	}

	static private void carregarSceneEtapa1(int fase,Activity game) {

		if (fase + 1 == 1) {
			carregar = new Fase1_Assets(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_01;
		}
		if (fase + 1 == 2) {
			carregar = new Fase2_Assets(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_02;
		}
		if (fase + 1 == 3) {
			carregar = new Fase3_Assets(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_03;
		}
		if (fase + 1 == 4) {
			carregar = new Fase4_Assets(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_04;
		}
		if (fase + 1 == 5) {
			carregar = new Fase5_Assets(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_05;
		}
		if (fase + 1 == 6) {
			carregar = new Fase6_Assets(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_06;
		}
		if (fase + 1 == 7) {
			carregar = new Fase7_Assets(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_07;
		}
		if (fase + 1 == 8) {
			carregar = new Fase8_Assets(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_08;
		}
		if (fase + 1 == 9) {
			carregar = new Fase9_Assets(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_09;
		}
	}

	static private void carregarSceneEtapa2(int fase,Activity game) {
		if (fase + 1 == 1) {
			carregar = new Fase1_Assets_ETAPA2(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_01_ETAPA2;
		}
		if (fase + 1 == 2) {
			carregar = new Fase2_Assets_ETAPA2(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_02_ETAPA2;
		}
		if (fase + 1 == 3) {
			carregar = new Fase3_Assets_ETAPA2(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_03_ETAPA2;
		}
		if (fase + 1 == 4) {
			carregar = new Fase4_Assets_ETAPA2(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_04_ETAPA2;
		}
		if (fase + 1 == 5) {
			carregar = new Fase5_Assets_ETAPA2(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_05_ETAPA2;
		}
		if (fase + 1 == 6) {
			carregar = new Fase6_Assets_ETAPA2(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_06_ETAPA2;
		}
		if (fase + 1 == 7) {
			carregar = new Fase7_Assets_ETAPA2(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_07_ETAPA2;
		}
		if (fase + 1 == 8) {
			carregar = new Fase8_Assets_ETAPA2(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_08_ETAPA2;
		}
		if (fase + 1 == 9) {
			carregar = new Fase9_Assets_ETAPA2(game);

			SceneManager.currentScene = SCENE.SCN_LEVEL_09_ETAPA2;
		}
	}

	static public void ChangeScene(Context game) {

		switch (SceneManager.currentScene) {
		
		case SCN_LEVEL_01:

			carregar = new Fase2_Assets(game);
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_02;

			break;
		case SCN_LEVEL_02:

			carregar = new Fase3_Assets(game);
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_03;

			break;
		case SCN_LEVEL_03:

			carregar = new Fase4_Assets(game);
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_04;

			break;
		case SCN_LEVEL_04:

			carregar = new Fase5_Assets(game);
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_05;

			break;
		case SCN_LEVEL_05:

			carregar = new Fase6_Assets(game);
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_06;

			break;

		case SCN_LEVEL_06:

			carregar = new Fase7_Assets(game);
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_07;

			break;
		case SCN_LEVEL_07:

			carregar = new Fase8_Assets(game);
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_08;

			break;
		case SCN_LEVEL_08:

			carregar = new Fase9_Assets(game);
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_09;

			break;
		case SCN_LEVEL_09:

			carregar = new Fase1_Assets_ETAPA2(game);
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_01_ETAPA2;

			break;

		case SCN_LEVEL_01_ETAPA2:

			carregar = new Fase2_Assets_ETAPA2(game);
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_02_ETAPA2;

			break;
		case SCN_LEVEL_02_ETAPA2:

			carregar = new Fase3_Assets_ETAPA2(game);
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_03_ETAPA2;

			break;
		case SCN_LEVEL_03_ETAPA2:

			carregar = new Fase4_Assets_ETAPA2(game);
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_04_ETAPA2;

			break;
		case SCN_LEVEL_04_ETAPA2:

			carregar = new Fase5_Assets_ETAPA2(game);
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_05_ETAPA2;

			break;
		case SCN_LEVEL_05_ETAPA2:

			carregar = new Fase6_Assets_ETAPA2(game);
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_06_ETAPA2;

			break;

		case SCN_LEVEL_06_ETAPA2:

			carregar = new Fase7_Assets_ETAPA2(game);
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_07_ETAPA2;

			break;
		case SCN_LEVEL_07_ETAPA2:

			carregar = new Fase8_Assets_ETAPA2(game);
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_08_ETAPA2;

			break;
		case SCN_LEVEL_08_ETAPA2:

			carregar = new Fase9_Assets_ETAPA2(game);
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_09_ETAPA2;

			break;
		case SCN_LEVEL_09_ETAPA2:

			carregar = new Vitoria(game);

			SceneManager.scene.Vitoria=true;
			SceneManager.scene.setFase(carregar);
			SceneManager.currentScene = SCENE.SCN_VITORIA;

			SoundManager.getInstance().StopSong("Game");

			if(SceneManager.sound){
			SoundManager.getInstance().playSound(R.raw.musicvitoria,
					"VitoriaSound", false, game);
			}
			break;
			
		// case SCENE.SCN_GAMEOVER:
		// SceneManager.scene = new Opening(game);
		// SceneManager.currentScene = SCENE.SCN_OPENING;
		// break;

		default:
			carregar = new Fase1_Assets(game);
			SceneManager.scene = new Fase02(game, carregar);
			SceneManager.currentScene = SCENE.SCN_LEVEL_01;
			break;
		}

	}

	public enum SCENE {
		SCN_LEVEL_01, SCN_LEVEL_02, SCN_LEVEL_03, SCN_LEVEL_04, SCN_LEVEL_05, SCN_LEVEL_06, SCN_LEVEL_07, SCN_LEVEL_08, SCN_LEVEL_09, SCN_LEVEL_10, SCN_LEVEL_11, SCN_LEVEL_12, SCN_LEVEL_01_ETAPA2, SCN_LEVEL_02_ETAPA2, SCN_LEVEL_03_ETAPA2, SCN_LEVEL_04_ETAPA2, SCN_LEVEL_05_ETAPA2, SCN_LEVEL_06_ETAPA2, SCN_LEVEL_07_ETAPA2, SCN_LEVEL_08_ETAPA2, SCN_LEVEL_09_ETAPA2, SCN_VITORIA
	}

}
