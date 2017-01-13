package ru.rubicon.client.implementations.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.rubicon.client.R;
import ru.rubicon.client.interfaces.IOnItemClick;
import ru.rubicon.client.model.odata.MetadataValue;
import ru.rubicon.client.model.odata.odinesnik.Document;

public class DocumentDocAdapter extends RecyclerView.Adapter<DocumentDocAdapter.MyHolder>{
    private List<Document> values;
    private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    private IOnItemClick onItemClick;

    public DocumentDocAdapter(List<Document> values, IOnItemClick onItemClick) {
        this.onItemClick = onItemClick;
        this.values = values;
        setHasStableIds(true);
    }

    public void update(List<Document> documentList) {
        this.values = documentList;
        notifyDataSetChanged();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.metadata_ui_item_layout, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Document document = values.get(position);
        String deleteMark = document.isDeletionMark() ? "[-]" : "[ ]";
        String postMark = document.isPosted() ? "[v]" : "[ ]";
        holder.tvMetadataValue.setText(deleteMark + "|" + postMark + "| " + document.getDate()
                + " | " + document.getNumber());

        holder.holderView.setOnClickListener(v -> onItemClick.onItemClickAction(v, document.getRefKey()));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvMetadaValue) TextView tvMetadataValue;

        public final View holderView;

        public MyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            holderView = itemView;
        }
    }
}
