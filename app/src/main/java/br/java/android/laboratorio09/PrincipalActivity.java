package br.java.android.laboratorio09;



import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class PrincipalActivity extends Activity {

    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab aba = actionBar.newTab()
                .setText("Aluguel")
                .setTabListener(
                        (ActionBar.TabListener) new MenuTabListener(
                                this,
                                "aluguel",
                                AluguelFragment.class));
        actionBar.addTab(aba);

        aba = actionBar.newTab()
                .setText("Venda")
                .setTabListener(
                        (ActionBar.TabListener)  new MenuTabListener(
                                this,
                                "venda",
                                VendaFragment.class));
        actionBar.addTab(aba);

        aba = actionBar.newTab()
                .setText("Aluguel")
                .setTabListener(
                        (ActionBar.TabListener)  new MenuTabListener(
                                this,
                                "aluguel",
                                AluguelFragment.class));
        actionBar.addTab(aba);

        if (savedInstanceState != null) {
            actionBar.setSelectedNavigationItem(savedInstanceState.getInt("selected"));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_principal, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.itemBuscar){
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
}
