package com.nativo.bedsideclock;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.nativo.bedsideclock.databinding.ActivityMainBinding;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // TAG usada para Log - Fácil identificação
    private static final String TAG = "MainActivity";
    private final Handler handler = new Handler();
    private ActivityMainBinding binding;
    private Runnable runner;


    private final BroadcastReceiver batteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            binding.textViewBattery.setText(getString(R.string.label_battery, level));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setFlags();

        registerReceiver(batteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        setListeners();
        hideOptions();
        startBedside();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(batteryReceiver);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.checkBox_battery) {
            toggleBatteryLevel();
        } else if (id == R.id.imageView_settings) {
            showOptions();
        } else if (id == R.id.imageView_close) {
            hideOptions();
        }
    }


    private void setFlags() {
        // Remove a barra superior
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Faz com que o dispositivo não bloqueie desde que permaneça nessa activity
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }


    private void showOptions() {
        binding.checkBoxBattery.animate().translationY(0).setDuration(400);
        binding.imageViewClose.animate().translationY(0).setDuration(400);
    }


    private void hideOptions() {
        int duration = 400;

        // Aguarda a renderização dos componentes antes de calcular suas alturas e margens
        binding.checkBoxBattery.post(new Runnable() {
            @Override
            public void run() {
                // Obtém a altura do CheckBox após o layout ter sido calculado
                int checkboxHeight = binding.checkBoxBattery.getHeight();

                // Obtém os parâmetros de layout do CheckBox para acessar suas margens
                ViewGroup.MarginLayoutParams checkboxParams = (ViewGroup.MarginLayoutParams) binding.checkBoxBattery.getLayoutParams();

                // Obtém a margem inferior do CheckBox
                int checkboxBottomMargin = checkboxParams.bottomMargin;

                // Calcula a altura total para ocultar o CheckBox (altura do componente + margem inferior)
                int totalCheckboxHideHeight = checkboxHeight + checkboxBottomMargin;

                // Aplica a animação para mover o CheckBox para fora da tela verticalmente
                binding.checkBoxBattery.animate().translationY(totalCheckboxHideHeight).setDuration(duration);
            }
        });

        // Aguarda a renderização dos componentes antes de calcular suas alturas e margens
        // Uso de lambda para simplificar escrita de classe anônima
        binding.imageViewClose.post(() -> {
            // Obtém a altura do botão de fechar após o layout ter sido calculado
            int closeImageHeight = binding.imageViewClose.getHeight();

            // Obtém os parâmetros de layout do botão de fechar para acessar suas margens
            ViewGroup.MarginLayoutParams closeImageParams = (ViewGroup.MarginLayoutParams) binding.imageViewClose.getLayoutParams();

            // Obtém a margem inferior do botão de fechar
            int closeImageBottomMargin = closeImageParams.bottomMargin;

            // Calcula a altura total para ocultar o botão de fechar (altura do componente + margem inferior)
            int totalCloseImageHideHeight = closeImageHeight + closeImageBottomMargin;

            // Aplica a animação para mover o botão de fechar para fora da tela verticalmente
            binding.imageViewClose.animate().translationY(totalCloseImageHideHeight).setDuration(duration);
        });
    }


    private void toggleBatteryLevel() {
        boolean isVisible = binding.textViewBattery.getVisibility() == View.VISIBLE;
        binding.textViewBattery.setVisibility(isVisible ? View.GONE : View.VISIBLE);
    }


    private void setListeners() {
        binding.checkBoxBattery.setOnClickListener(this);
        binding.imageViewSettings.setOnClickListener(this);
        binding.imageViewClose.setOnClickListener(this);
    }

    private void startBedside() {
        runner = new Runnable() {
            @Override
            public void run() {
                // Inicializa o calendário
                Calendar calendar = Calendar.getInstance();

                // Obtém o tempo do celular e atribui ao calendário criado
                calendar.setTimeInMillis(System.currentTimeMillis());

                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                int second = calendar.get(Calendar.SECOND);

                // Converte
                String hourMinutesFormat = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
                String secondsFormat = String.format(Locale.getDefault(), "%02d", second);

                // Atribui
                binding.textViewHourMinute.setText(hourMinutesFormat);
                binding.textViewSecond.setText(secondsFormat);

                // Cálculo de quando a thread vai rodar novamente
                long now = SystemClock.uptimeMillis();
                long next = now + (1000 - (now % 1000));
                handler.postAtTime(runner, next);

                // Uso de logs - Do menos crítico para o mais
                /* Log.v(TAG, "verbose");
                Log.d(TAG, "debug");
                Log.i(TAG, "info");
                Log.w(TAG, "warn");
                Log.e(TAG, "error");*/
            }
        };
        runner.run();
    }
}