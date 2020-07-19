package com.example.psgetdegrees;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.psgetdegrees.assessmentProvider.Assessment;
import com.example.psgetdegrees.assessmentProvider.AssessmentViewModel;

import java.util.ArrayList;

public class AssessRecyclerAdapter extends RecyclerView.Adapter<AssessRecyclerAdapter.ViewHolder> {

    private ArrayList<Assessment> data;
    private AssessmentViewModel aViewModel;
    private DeleteListener deleteListener;

    public AssessRecyclerAdapter(ArrayList<Assessment> data, AssessmentViewModel aViewModel) {
        this.data = data;
        this.aViewModel = aViewModel;
    }

    public void setDeleteListener(DeleteListener callBack) {
        this.deleteListener = callBack;
    }

    public void setData(ArrayList<Assessment> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AssessRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.assess_card_layout, parent, false);
        AssessRecyclerAdapter.ViewHolder viewHolder = new AssessRecyclerAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AssessRecyclerAdapter.ViewHolder holder, int position) {
        holder.tvAssessmentName.setText(data.get(position).getAssessmentName());
        holder.tvValue.setText(data.get(position).getValue());
        holder.tvMark.setText(data.get(position).getMark());
        holder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteListener.onClickDel(data.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvAssessmentName;
        public TextView tvValue;
        public TextView tvMark;
        public ImageButton btnDel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAssessmentName = itemView.findViewById(R.id.tv_assessment_name);
            tvValue = itemView.findViewById(R.id.tv_value_input);
            tvMark = itemView.findViewById(R.id.tv_mark_input);
            btnDel = itemView.findViewById(R.id.btn_del);
        }
    }
}