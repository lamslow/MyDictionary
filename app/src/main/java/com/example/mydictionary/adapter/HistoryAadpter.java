package com.example.mydictionary.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydictionary.R;
import com.example.mydictionary.activity.DetailWordActivity;
import com.example.mydictionary.dao.HistoryDAO;
import com.example.mydictionary.holder.HistoryHolder;
import com.example.mydictionary.model.History;

import java.util.List;

public class HistoryAadpter extends RecyclerView.Adapter<HistoryHolder> {
    private Context context;
    private List<History> list;
    private HistoryDAO historyDAO;

    public HistoryAadpter(Context context, List<History> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_view, parent, false);
        HistoryHolder historyHolder = new HistoryHolder(view);
        return historyHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HistoryHolder holder, final int position) {
        holder.tvWordHis.setText(list.get(position).wordHistory);
        holder.imgDelHis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                View view = LayoutInflater.from(context).inflate(R.layout.dialog_fav, null);
                builder.setTitle("Bạn có muốn xóa lịch sử không");
                builder.setView(view);
                final AlertDialog dialog = builder.show();
                Button btnCancel, btnOk;
                btnCancel = dialog.findViewById(R.id.btnCancel);
                btnOk = dialog.findViewById(R.id.btnOk);
                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        historyDAO = new HistoryDAO(context);
                        int result = historyDAO.delHistory(list.get(position).wordHistory);
                        if (result > 0) {
                            dialog.dismiss();
                            Toast.makeText(context, "Xoa lịch sử thành công", Toast.LENGTH_SHORT).show();
                            list.remove(position);
                            notifyDataSetChanged();
                        } else {
                            dialog.dismiss();
                            Toast.makeText(context, "Xóa lịch sử thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailWordActivity.class);
                intent.putExtra("data",list.get(position).wordHistory);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
