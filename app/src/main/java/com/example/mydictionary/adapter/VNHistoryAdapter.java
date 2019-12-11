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
import com.example.mydictionary.activity.SearchAVActivity;
import com.example.mydictionary.activity.SearchVAActivity;
import com.example.mydictionary.dao.HistoryDAO;
import com.example.mydictionary.dao.VNHistoryDAO;
import com.example.mydictionary.holder.HistoryHolder;
import com.example.mydictionary.model.History;
import com.example.mydictionary.model.VNHistory;

import java.util.List;

public class VNHistoryAdapter extends RecyclerView.Adapter<HistoryHolder> {
    private Context context;
    private List<VNHistory> list;
    private VNHistoryDAO vnHistoryDAO;

    public VNHistoryAdapter(Context context, List<VNHistory> list) {
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
    public void onBindViewHolder(@NonNull HistoryHolder holder, final int position) {
        holder.tvWordHis.setText(list.get(position).vnHistoryWord);
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
                        vnHistoryDAO = new VNHistoryDAO(context);
                        int result = vnHistoryDAO.delVNHistory(list.get(position).vnHistoryWord);
                        if (result > 0) {
                            dialog.dismiss();
                            Toast.makeText(context, "Xóa lịch sử thành công", Toast.LENGTH_SHORT).show();
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
                Intent intent = new Intent(context, SearchVAActivity.class);
                intent.putExtra("dataVnHis", list.get(position).vnHistoryWord);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
