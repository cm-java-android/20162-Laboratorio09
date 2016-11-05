package br.java.android.laboratorio09;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.ActionBar;
import android.app.FragmentTransaction;

@SuppressLint("ValidFragment")
public class MenuTabListener<A extends Fragment> extends Fragment implements ActionBar.TabListener {

    private Fragment meuFragment;
    private final Activity minhaActivity;
    private final String meuTag;
    private final Class<Fragment> minhaClasse;

    public MenuTabListener(Activity minhaActivity, String meuTag, Class<Fragment> minhaClasse) {
        this.minhaActivity = minhaActivity;
        this.meuTag = meuTag;
        this.minhaClasse = minhaClasse;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        meuFragment = minhaActivity.getFragmentManager()
                        .findFragmentByTag(meuTag);
        // Verifico se o Fragment ja foi instanciado
        if(meuFragment == null){
            // Crio uma instância e adiciono
            meuFragment = Fragment.instantiate(minhaActivity,minhaClasse.getName());
            fragmentTransaction.add(android.R.id.content, meuFragment,meuTag);
        }else{
            // Caso contrario, apenas adiciono ele
            fragmentTransaction.attach(meuFragment);
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        if(meuFragment != null){
            // Removo o Fragment pois outro será acessado
            fragmentTransaction.detach(meuFragment);
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {


    }
}
